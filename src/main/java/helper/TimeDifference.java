package helper;

import lombok.Data;

/**
 * @Title TimeDifference
 * @Author Administrator
 * @Description
 * @Date 2024/9/25 9:55
 * @Version 1.0
 **/
@Data
public class TimeDifference {
    private Long day;
    private Long hour;
    private Long min;
    private Long sec;
    private Long totalSec;

    public TimeDifference() {
    }
    public TimeDifference(Long day, Long hour, Long min, Long sec, Long totalSec) {
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.sec=sec;
        this.totalSec=totalSec;
    }
}
