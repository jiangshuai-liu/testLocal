package com.work1;

import java.util.Random;

public class Ant {
    private static final int CITIES = 5;
    private static final int ANTS = 10;
    private static final int MAX_ITERATIONS = 1000;
    /**
     * 信息素重要性
     */
    private static final double ALPHA = 1.0;
    /**
     * 启发信息重要性
     */
    private static final double BETA = 5.0;
    /**
     * 信息素挥发率
     */
    private static final double EVAPORATION = 0.5;
    /**
     * 信息素增强常数
     */
    private static final double Q = 100;

    private final double[][] distances;
    private final double[][] pheromones;

    private final Random random = new Random();

    public Ant(double[][] distances) {
        this.distances = distances;
        this.pheromones = new double[CITIES][CITIES];

        // 初始化信息素矩阵
        for (int i = 0; i < CITIES; i++) {
            for (int j = 0; j < CITIES; j++) {
                pheromones[i][j] = 1.0;
            }
        }
    }

    public void solve() {
        int[] bestTour = null;
        double bestTourLength = Double.MAX_VALUE;

        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            int[][] tours = new int[ANTS][CITIES];
            double[] tourLengths = new double[ANTS];

            // 每只蚂蚁生成一条路径
            for (int ant = 0; ant < ANTS; ant++) {
                tours[ant] = constructTour();
                tourLengths[ant] = calculateTourLength(tours[ant]);

                // 更新最佳路径
                if (tourLengths[ant] < bestTourLength) {
                    bestTourLength = tourLengths[ant];
                    bestTour = tours[ant];
                }
            }

            // 更新信息素
            evaporatePheromones();
            for (int ant = 0; ant < ANTS; ant++) {
                depositPheromones(tours[ant], tourLengths[ant]);
            }
        }

        // 输出最优解
        System.out.println("Best tour length: " + bestTourLength);
        System.out.print("Best tour: ");
        for (int city : bestTour) {
            System.out.print(city + " ");
        }
        System.out.println();
    }

    private int[] constructTour() {
        boolean[] visited = new boolean[CITIES];
        int[] tour = new int[CITIES];
        int currentCity = random.nextInt(CITIES);

        tour[0] = currentCity;
        visited[currentCity] = true;

        for (int i = 1; i < CITIES; i++) {
            int nextCity = selectNextCity(currentCity, visited);
            tour[i] = nextCity;
            visited[nextCity] = true;
            currentCity = nextCity;
        }

        return tour;
    }

    private int selectNextCity(int currentCity, boolean[] visited) {
        double[] probabilities = new double[CITIES];
        double sum = 0.0;

        for (int city = 0; city < CITIES; city++) {
            if (!visited[city]) {
                probabilities[city] = Math.pow(pheromones[currentCity][city], ALPHA) *
                        Math.pow(1.0 / distances[currentCity][city], BETA);
                sum += probabilities[city];
            } else {
                probabilities[city] = 0.0;
            }
        }

        double rand = random.nextDouble() * sum;
        for (int city = 0; city < CITIES; city++) {
            if (!visited[city]) {
                rand -= probabilities[city];
                if (rand <= 0.0) {
                    return city;
                }
            }
        }
        return -1;
    }

    private double calculateTourLength(int[] tour) {
        double length = 0.0;
        for (int i = 0; i < CITIES - 1; i++) {
            length += distances[tour[i]][tour[i + 1]];
        }

        length += distances[tour[CITIES - 1]][tour[0]];
        return length;
    }

    private void evaporatePheromones() {
        for (int i = 0; i < CITIES; i++) {
            for (int j = 0; j < CITIES; j++) {
                pheromones[i][j] *= (1 - EVAPORATION);
            }
        }
    }

    private void depositPheromones(int[] tour, double tourLength) {
        double pheromoneToDeposit = Q / tourLength;
        for (int i = 0; i < CITIES - 1; i++) {
            pheromones[tour[i]][tour[i + 1]] += pheromoneToDeposit;
            pheromones[tour[i + 1]][tour[i]] += pheromoneToDeposit;
        }
        pheromones[tour[CITIES - 1]][tour[0]] += pheromoneToDeposit;
        pheromones[tour[0]][tour[CITIES - 1]] += pheromoneToDeposit;
    }

    public static void main(String[] args) {

        double[][] distances = {
                {0, 2, 2, 5, 7},
                {2, 0, 4, 8, 2},
                {2, 4, 0, 1, 3},
                {5, 8, 1, 0, 2},
                {7, 2, 3, 2, 0}
        };
        Ant tsp = new Ant(distances);
        tsp.solve();
    }
}