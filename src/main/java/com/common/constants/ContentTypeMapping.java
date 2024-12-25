package com.common.constants;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
public class ContentTypeMapping {

    public static String getContentType(String fileType) {
        return Optional.ofNullable(map.get(fileType)).orElse("application/octet-stream");
    }
    public static final Map<String, String> map = new ConcurrentHashMap<String, String>() {
        {
            put(".load", "text/html");
            put(".123", "application/vnd.lotus-1-2-3");
            put(".3ds", "image/x-3ds");
            put(".3g2", "video/3gpp");
            put(".3ga", "video/3gpp");
            put(".3gp", "video/3gpp");
            put(".3gpp", "video/3gpp");
            put(".602", "application/x-t602");
            put(".669", "audio/x-mod");
            put(".7z", "application/x-7z-compressed");
            put(".a", "application/x-archive");
            put(".aac", "audio/mp4");
            put(".abw", "application/x-abiword");
            put(".abw.crashed", "application/x-abiword");
            put(".abw.gz", "application/x-abiword");
            put(".ac3", "audio/ac3");
            put(".ace", "application/x-ace");
            put(".adb", "text/x-adasrc");
            put(".ads", "text/x-adasrc");
            put(".afm", "application/x-font-afm");
            put(".ag", "image/x-applix-graphics");
            put(".ai", "application/illustrator");
            put(".aif", "audio/x-aiff");
            put(".aifc", "audio/x-aiff");
            put(".aiff", "audio/x-aiff");
            put(".al", "application/x-perl");
            put(".alz", "application/x-alz");
            put(".amr", "audio/amr");
            put(".ani", "application/x-navi-animation");
            put(".anim[1-9j]", "video/x-anim");
            put(".anx", "application/annodex");
            put(".ape", "audio/x-ape");
            put(".arj", "application/x-arj");
            put(".arw", "image/x-sony-arw");
            put(".as", "application/x-applix-spreadsheet");
            put(".asc", "text/plain");
            put(".asf", "video/x-ms-asf");
            put(".asp", "application/x-asp");
            put(".ass", "text/x-ssa");
            put(".asx", "audio/x-ms-asx");
            put(".atom", "application/atom+xml");
            put(".au", "audio/basic");
            put(".avi", "video/x-msvideo");
            put(".aw", "application/x-applix-word");
            put(".awb", "audio/amr-wb");
            put(".awk", "application/x-awk");
            put(".axa", "audio/annodex");
            put(".axv", "video/annodex");
            put(".bak", "application/x-trash");
            put(".bcpio", "application/x-bcpio");
            put(".bdf", "application/x-font-bdf");
            put(".bib", "text/x-bibtex");
            put(".bin", "application/octet-stream");
            put(".blend", "application/x-blender");
            put(".blender", "application/x-blender");
            put(".bmp", "image/bmp");
            put(".bz", "application/x-bzip");
            put(".bz2", "application/x-bzip");
            put(".c", "text/x-csrc");
            put(".c++", "text/x-c++src");
            put(".cab", "application/vnd.ms-cab-compressed");
            put(".cb7", "application/x-cb7");
            put(".cbr", "application/x-cbr");
            put(".cbt", "application/x-cbt");
            put(".cbz", "application/x-cbz");
            put(".cc", "text/x-c++src");
            put(".cdf", "application/x-netcdf");
            put(".cdr", "application/vnd.corel-draw");
            put(".cer", "application/x-x509-ca-cert");
            put(".cert", "application/x-x509-ca-cert");
            put(".cgm", "image/cgm");
            put(".chm", "application/x-chm");
            put(".chrt", "application/x-kchart");
            put(".class", "application/x-java");
            put(".cls", "text/x-tex");
            put(".cmake", "text/x-cmake");
            put(".cpio", "application/x-cpio");
            put(".cpio.gz", "application/x-cpio-compressed");
            put(".cpp", "text/x-c++src");
            put(".cr2", "image/x-canon-cr2");
            put(".crt", "application/x-x509-ca-cert");
            put(".crw", "image/x-canon-crw");
            put(".cs", "text/x-csharp");
            put(".csh", "application/x-csh");
            put(".css", "text/css");
            put(".cssl", "text/css");
            put(".csv", "text/csv");
            put(".cue", "application/x-cue");
            put(".cur", "image/x-win-bitmap");
            put(".cxx", "text/x-c++src");
            put(".d", "text/x-dsrc");
            put(".dar", "application/x-dar");
            put(".dbf", "application/x-dbf");
            put(".dc", "application/x-dc-rom");
            put(".dcl", "text/x-dcl");
            put(".dcm", "application/dicom");
            put(".dcr", "image/x-kodak-dcr");
            put(".dds", "image/x-dds");
            put(".deb", "application/x-deb");
            put(".der", "application/x-x509-ca-cert");
            put(".desktop", "application/x-desktop");
            put(".dia", "application/x-dia-diagram");
            put(".diff", "text/x-patch");
            put(".divx", "video/x-msvideo");
            put(".djv", "image/vnd.djvu");
            put(".djvu", "image/vnd.djvu");
            put(".dng", "image/x-adobe-dng");
            put(".doc", "application/msword");
            put(".docbook", "application/docbook+xml");
            put(".docm", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            put(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            put(".dot", "text/vnd.graphviz");
            put(".dsl", "text/x-dsl");
            put(".dtd", "application/xml-dtd");
            put(".dtx", "text/x-tex");
            put(".dv", "video/dv");
            put(".dvi", "application/x-dvi");
            put(".dvi.bz2", "application/x-bzdvi");
            put(".dvi.gz", "application/x-gzdvi");
            put(".dwg", "image/vnd.dwg");
            put(".dxf", "image/vnd.dxf");
            put(".e", "text/x-eiffel");
            put(".egon", "application/x-egon");
            put(".eif", "text/x-eiffel");
            put(".el", "text/x-emacs-lisp");
            put(".emf", "image/x-emf");
            put(".emp", "application/vnd.emusic-emusic_package");
            put(".ent", "application/xml-external-parsed-entity");
            put(".eps", "image/x-eps");
            put(".eps.bz2", "image/x-bzeps");
            put(".eps.gz", "image/x-gzeps");
            put(".epsf", "image/x-eps");
            put(".epsf.bz2", "image/x-bzeps");
            put(".epsf.gz", "image/x-gzeps");
            put(".epsi", "image/x-eps");
            put(".epsi.bz2", "image/x-bzeps");
            put(".epsi.gz", "image/x-gzeps");
            put(".epub", "application/epub+zip");
            put(".erl", "text/x-erlang");
            put(".es", "application/ecmascript");
            put(".etheme", "application/x-e-theme");
            put(".etx", "text/x-setext");
            put(".exe", "application/x-ms-dos-executable");
            put(".exr", "image/x-exr");
            put(".ez", "application/andrew-inset");
            put(".f", "text/x-fortran");
            put(".f90", "text/x-fortran");
            put(".f95", "text/x-fortran");
            put(".fb2", "application/x-fictionbook+xml");
            put(".fig", "image/x-xfig");
            put(".fits", "image/fits");
            put(".fl", "application/x-fluid");
            put(".flac", "audio/x-flac");
            put(".flc", "video/x-flic");
            put(".fli", "video/x-flic");
            put(".flv", "video/x-flv");
            put(".flw", "application/x-kivio");
            put(".fo", "text/x-xslfo");
            put(".for", "text/x-fortran");
            put(".g3", "image/fax-g3");
            put(".gb", "application/x-gameboy-rom");
            put(".gba", "application/x-gba-rom");
            put(".gcrd", "text/directory");
            put(".ged", "application/x-gedcom");
            put(".gedcom", "application/x-gedcom");
            put(".gen", "application/x-genesis-rom");
            put(".gf", "application/x-tex-gf");
            put(".gg", "application/x-sms-rom");
            put(".gif", "image/gif");
            put(".glade", "application/x-glade");
            put(".gmo", "application/x-gettext-translation");
            put(".gnc", "application/x-gnucash");
            put(".gnd", "application/gnunet-directory");
            put(".gnucash", "application/x-gnucash");
            put(".gnumeric", "application/x-gnumeric");
            put(".gnuplot", "application/x-gnuplot");
            put(".gp", "application/x-gnuplot");
            put(".gpg", "application/pgp-encrypted");
            put(".gplt", "application/x-gnuplot");
            put(".gra", "application/x-graphite");
            put(".gsf", "application/x-font-type1");
            put(".gsm", "audio/x-gsm");
            put(".gtar", "application/x-tar");
            put(".gv", "text/vnd.graphviz");
            put(".gvp", "text/x-google-video-pointer");
            put(".gz", "application/x-gzip");
            put(".h", "text/x-chdr");
            put(".h++", "text/x-c++hdr");
            put(".hdf", "application/x-hdf");
            put(".hh", "text/x-c++hdr");
            put(".hp", "text/x-c++hdr");
            put(".hpgl", "application/vnd.hp-hpgl");
            put(".hpp", "text/x-c++hdr");
            put(".hs", "text/x-haskell");
            put(".htm", "text/html");
            put(".html", "text/html");
            put(".hwp", "application/x-hwp");
            put(".hwt", "application/x-hwt");
            put(".hxx", "text/x-c++hdr");
            put(".ica", "application/x-ica");
            put(".icb", "image/x-tga");
            put(".icns", "image/x-icns");
            put(".ico", "image/vnd.microsoft.icon");
            put(".ics", "text/calendar");
            put(".idl", "text/x-idl");
            put(".ief", "image/ief");
            put(".iff", "image/x-iff");
            put(".ilbm", "image/x-ilbm");
            put(".ime", "text/x-imelody");
            put(".imy", "text/x-imelody");
            put(".ins", "text/x-tex");
            put(".iptables", "text/x-iptables");
            put(".iso", "application/x-cd-image");
            put(".iso9660", "application/x-cd-image");
            put(".it", "audio/x-it");
            put(".j2k", "image/jp2");
            put(".jad", "text/vnd.sun.j2me.app-descriptor");
            put(".jar", "application/x-java-archive");
            put(".java", "text/x-java");
            put(".jng", "image/x-jng");
            put(".jnlp", "application/x-java-jnlp-file");
            put(".jp2", "image/jp2");
            put(".jpc", "image/jp2");
            put(".jpe", "image/jpeg");
            put(".jpeg", "image/jpeg");
            put(".jpf", "image/jp2");
            put(".jpg", "image/jpeg");
            put(".jpr", "application/x-jbuilder-project");
            put(".jpx", "image/jp2");
            put(".js", "application/javascript");
            put(".json", "application/json");
            put(".jsonp", "application/jsonp");
            put(".k25", "image/x-kodak-k25");
            put(".kar", "audio/midi");
            put(".karbon", "application/x-karbon");
            put(".kdc", "image/x-kodak-kdc");
            put(".kdelnk", "application/x-desktop");
            put(".kexi", "application/x-kexiproject-sqlite3");
            put(".kexic", "application/x-kexi-connectiondata");
            put(".kexis", "application/x-kexiproject-shortcut");
            put(".kfo", "application/x-kformula");
            put(".kil", "application/x-killustrator");
            put(".kino", "application/smil");
            put(".kml", "application/vnd.google-earth.kml+xml");
            put(".kmz", "application/vnd.google-earth.kmz");
            put(".kon", "application/x-kontour");
            put(".kpm", "application/x-kpovmodeler");
            put(".kpr", "application/x-kpresenter");
            put(".kpt", "application/x-kpresenter");
            put(".kra", "application/x-krita");
            put(".ksp", "application/x-kspread");
            put(".kud", "application/x-kugar");
            put(".kwd", "application/x-kword");
            put(".kwt", "application/x-kword");
            put(".la", "application/x-shared-library-la");
            put(".latex", "text/x-tex");
            put(".ldif", "text/x-ldif");
            put(".lha", "application/x-lha");
            put(".lhs", "text/x-literate-haskell");
            put(".lhz", "application/x-lhz");
            put(".log", "text/x-log");
            put(".ltx", "text/x-tex");
            put(".lua", "text/x-lua");
            put(".lwo", "image/x-lwo");
            put(".lwob", "image/x-lwo");
            put(".lws", "image/x-lws");
            put(".ly", "text/x-lilypond");
            put(".lyx", "application/x-lyx");
            put(".lz", "application/x-lzip");
            put(".lzh", "application/x-lha");
            put(".lzma", "application/x-lzma");
            put(".lzo", "application/x-lzop");
            put(".m", "text/x-matlab");
            put(".m15", "audio/x-mod");
            put(".m2t", "video/mpeg");
            put(".m3u", "audio/x-mpegurl");
            put(".m3u8", "audio/x-mpegurl");
            put(".m4", "application/x-m4");
            put(".m4a", "audio/mp4");
            put(".m4b", "audio/x-m4b");
            put(".m4v", "video/mp4");
            put(".mab", "application/x-markaby");
            put(".man", "application/x-troff-man");
            put(".mbox", "application/mbox");
            put(".md", "application/x-genesis-rom");
            put(".mdb", "application/vnd.ms-access");
            put(".mdi", "image/vnd.ms-modi");
            put(".me", "text/x-troff-me");
            put(".med", "audio/x-mod");
            put(".metalink", "application/metalink+xml");
            put(".mgp", "application/x-magicpoint");
            put(".mid", "audio/midi");
            put(".midi", "audio/midi");
            put(".mif", "application/x-mif");
            put(".minipsf", "audio/x-minipsf");
            put(".mka", "audio/x-matroska");
            put(".mkv", "video/x-matroska");
            put(".ml", "text/x-ocaml");
            put(".mli", "text/x-ocaml");
            put(".mm", "text/x-troff-mm");
            put(".mmf", "application/x-smaf");
            put(".mml", "text/mathml");
            put(".mng", "video/x-mng");
            put(".mo", "application/x-gettext-translation");
            put(".mo3", "audio/x-mo3");
            put(".moc", "text/x-moc");
            put(".mod", "audio/x-mod");
            put(".mof", "text/x-mof");
            put(".moov", "video/quicktime");
            put(".mov", "video/quicktime");
            put(".movie", "video/x-sgi-movie");
            put(".mp+", "audio/x-musepack");
            put(".mp2", "video/mpeg");
            put(".mp3", "audio/mpeg");
            put(".mp4", "video/mp4");
            put(".mpc", "audio/x-musepack");
            put(".mpe", "video/mpeg");
            put(".mpeg", "video/mpeg");
            put(".mpg", "video/mpeg");
            put(".mpga", "audio/mpeg");
            put(".mpp", "audio/x-musepack");
            put(".mrl", "text/x-mrml");
            put(".mrml", "text/x-mrml");
            put(".mrw", "image/x-minolta-mrw");
            put(".ms", "text/x-troff-ms");
            put(".msi", "application/x-msi");
            put(".msod", "image/x-msod");
            put(".msx", "application/x-msx-rom");
            put(".mtm", "audio/x-mod");
            put(".mup", "text/x-mup");
            put(".mxf", "application/mxf");
            put(".n64", "application/x-n64-rom");
            put(".nb", "application/mathematica");
            put(".nc", "application/x-netcdf");
            put(".nds", "application/x-nintendo-ds-rom");
            put(".nef", "image/x-nikon-nef");
            put(".nes", "application/x-nes-rom");
            put(".nfo", "text/x-nfo");
            put(".not", "text/x-mup");
            put(".nsc", "application/x-netshow-channel");
            put(".nsv", "video/x-nsv");
            put(".o", "application/x-object");
            put(".obj", "application/x-tgif");
            put(".ocl", "text/x-ocl");
            put(".oda", "application/oda");
            put(".odb", "application/vnd.oasis.opendocument.database");
            put(".odc", "application/vnd.oasis.opendocument.chart");
            put(".odf", "application/vnd.oasis.opendocument.formula");
            put(".odg", "application/vnd.oasis.opendocument.graphics");
            put(".odi", "application/vnd.oasis.opendocument.image");
            put(".odm", "application/vnd.oasis.opendocument.text-master");
            put(".odp", "application/vnd.oasis.opendocument.presentation");
            put(".ods", "application/vnd.oasis.opendocument.spreadsheet");
            put(".odt", "application/vnd.oasis.opendocument.text");
            put(".oga", "audio/ogg");
            put(".ogg", "video/x-theora+ogg");
            put(".ogm", "video/x-ogm+ogg");
            put(".ogv", "video/ogg");
            put(".ogx", "application/ogg");
            put(".old", "application/x-trash");
            put(".oleo", "application/x-oleo");
            put(".opml", "text/x-opml+xml");
            put(".ora", "image/openraster");
            put(".orf", "image/x-olympus-orf");
            put(".otc", "application/vnd.oasis.opendocument.chart-template");
            put(".otf", "application/x-font-otf");
            put(".otg", "application/vnd.oasis.opendocument.graphics-template");
            put(".oth", "application/vnd.oasis.opendocument.text-web");
            put(".otp", "application/vnd.oasis.opendocument.presentation-template");
            put(".ots", "application/vnd.oasis.opendocument.spreadsheet-template");
            put(".ott", "application/vnd.oasis.opendocument.text-template");
            put(".owl", "application/rdf+xml");
            put(".oxt", "application/vnd.openofficeorg.extension");
            put(".p", "text/x-pascal");
            put(".p10", "application/pkcs10");
            put(".p12", "application/x-pkcs12");
            put(".p7b", "application/x-pkcs7-certificates");
            put(".p7s", "application/pkcs7-signature");
            put(".pack", "application/x-java-pack200");
            put(".pak", "application/x-pak");
            put(".par2", "application/x-par2");
            put(".pas", "text/x-pascal");
            put(".patch", "text/x-patch");
            put(".pbm", "image/x-portable-bitmap");
            put(".pcd", "image/x-photo-cd");
            put(".pcf", "application/x-cisco-vpn-settings");
            put(".pcf.gz", "application/x-font-pcf");
            put(".pcf.z", "application/x-font-pcf");
            put(".pcl", "application/vnd.hp-pcl");
            put(".pcx", "image/x-pcx");
            put(".pdb", "chemical/x-pdb");
            put(".pdc", "application/x-aportisdoc");
            put(".pdf", "application/pdf");
            put(".pdf.bz2", "application/x-bzpdf");
            put(".pdf.gz", "application/x-gzpdf");
            put(".pef", "image/x-pentax-pef");
            put(".pem", "application/x-x509-ca-cert");
            put(".perl", "application/x-perl");
            put(".pfa", "application/x-font-type1");
            put(".pfb", "application/x-font-type1");
            put(".pfx", "application/x-pkcs12");
            put(".pgm", "image/x-portable-graymap");
            put(".pgn", "application/x-chess-pgn");
            put(".pgp", "application/pgp-encrypted");
            put(".php", "application/x-php");
            put(".php3", "application/x-php");
            put(".php4", "application/x-php");
            put(".pict", "image/x-pict");
            put(".pict1", "image/x-pict");
            put(".pict2", "image/x-pict");
            put(".pickle", "application/python-pickle");
            put(".pk", "application/x-tex-pk");
            put(".pkipath", "application/pkix-pkipath");
            put(".pkr", "application/pgp-keys");
            put(".pl", "application/x-perl");
            put(".pla", "audio/x-iriver-pla");
            put(".pln", "application/x-planperfect");
            put(".pls", "audio/x-scpls");
            put(".pm", "application/x-perl");
            put(".png", "image/png");
            put(".pnm", "image/x-portable-anymap");
            put(".pntg", "image/x-macpaint");
            put(".po", "text/x-gettext-translation");
            put(".por", "application/x-spss-por");
            put(".pot", "text/x-gettext-translation-template");
            put(".ppm", "image/x-portable-pixmap");
            put(".pps", "application/vnd.ms-powerpoint");
            put(".ppt", "application/vnd.ms-powerpoint");
            put(".pptm", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
            put(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
            put(".ppz", "application/vnd.ms-powerpoint");
            put(".prc", "application/x-palm-database");
            put(".ps", "application/postscript");
            put(".ps.bz2", "application/x-bzpostscript");
            put(".ps.gz", "application/x-gzpostscript");
            put(".psd", "image/vnd.adobe.photoshop");
            put(".psf", "audio/x-psf");
            put(".psf.gz", "application/x-gz-font-linux-psf");
            put(".psflib", "audio/x-psflib");
            put(".psid", "audio/prs.sid");
            put(".psw", "application/x-pocket-word");
            put(".pw", "application/x-pw");
            put(".py", "text/x-python");
            put(".pyc", "application/x-python-bytecode");
            put(".pyo", "application/x-python-bytecode");
            put(".qif", "image/x-quicktime");
            put(".qt", "video/quicktime");
            put(".qtif", "image/x-quicktime");
            put(".qtl", "application/x-quicktime-media-link");
            put(".qtvr", "video/quicktime");
            put(".ra", "audio/vnd.rn-realaudio");
            put(".raf", "image/x-fuji-raf");
            put(".ram", "application/ram");
            put(".rar", "application/x-rar");
            put(".ras", "image/x-cmu-raster");
            put(".raw", "image/x-panasonic-raw");
            put(".rax", "audio/vnd.rn-realaudio");
            put(".rb", "application/x-ruby");
            put(".rdf", "application/rdf+xml");
            put(".rdfs", "application/rdf+xml");
            put(".reg", "text/x-ms-regedit");
            put(".rej", "application/x-reject");
            put(".rgb", "image/x-rgb");
            put(".rle", "image/rle");
            put(".rm", "application/vnd.rn-realmedia");
            put(".rmj", "application/vnd.rn-realmedia");
            put(".rmm", "application/vnd.rn-realmedia");
            put(".rms", "application/vnd.rn-realmedia");
            put(".rmvb", "application/vnd.rn-realmedia");
            put(".rmx", "application/vnd.rn-realmedia");
            put(".roff", "text/troff");
            put(".rp", "image/vnd.rn-realpix");
            put(".rpm", "application/x-rpm");
            put(".rss", "application/rss+xml");
            put(".rt", "text/vnd.rn-realtext");
            put(".rtf", "application/rtf");
            put(".rtx", "text/richtext");
            put(".rv", "video/vnd.rn-realvideo");
            put(".rvx", "video/vnd.rn-realvideo");
            put(".s3m", "audio/x-s3m");
            put(".sam", "application/x-amipro");
            put(".sami", "application/x-sami");
            put(".sav", "application/x-spss-sav");
            put(".scm", "text/x-scheme");
            put(".sda", "application/vnd.stardivision.draw");
            put(".sdc", "application/vnd.stardivision.calc");
            put(".sdd", "application/vnd.stardivision.impress");
            put(".sdp", "application/sdp");
            put(".sds", "application/vnd.stardivision.chart");
            put(".sdw", "application/vnd.stardivision.writer");
            put(".sgf", "application/x-go-sgf");
            put(".sgi", "image/x-sgi");
            put(".sgl", "application/vnd.stardivision.writer");
            put(".sgm", "text/sgml");
            put(".sgml", "text/sgml");
            put(".sh", "application/x-shellscript");
            put(".shar", "application/x-shar");
            put(".shn", "application/x-shorten");
            put(".siag", "application/x-siag");
            put(".sid", "audio/prs.sid");
            put(".sik", "application/x-trash");
            put(".sis", "application/vnd.symbian.install");
            put(".sisx", "x-epoc/x-sisx-app");
            put(".sit", "application/x-stuffit");
            put(".siv", "application/sieve");
            put(".sk", "image/x-skencil");
            put(".sk1", "image/x-skencil");
            put(".skr", "application/pgp-keys");
            put(".slk", "text/spreadsheet");
            put(".smaf", "application/x-smaf");
            put(".smc", "application/x-snes-rom");
            put(".smd", "application/vnd.stardivision.mail");
            put(".smf", "application/vnd.stardivision.math");
            put(".smi", "application/x-sami");
            put(".smil", "application/smil");
            put(".sml", "application/smil");
            put(".sms", "application/x-sms-rom");
            put(".snd", "audio/basic");
            put(".so", "application/x-sharedlib");
            put(".spc", "application/x-pkcs7-certificates");
            put(".spd", "application/x-font-speedo");
            put(".spec", "text/x-rpm-spec");
            put(".spl", "application/x-shockwave-flash");
            put(".spx", "audio/x-speex");
            put(".sql", "text/x-sql");
            put(".sr2", "image/x-sony-sr2");
            put(".src", "application/x-wais-source");
            put(".srf", "image/x-sony-srf");
            put(".srt", "application/x-subrip");
            put(".ssa", "text/x-ssa");
            put(".stc", "application/vnd.sun.xml.calc.template");
            put(".std", "application/vnd.sun.xml.draw.template");
            put(".sti", "application/vnd.sun.xml.impress.template");
            put(".stm", "audio/x-stm");
            put(".stw", "application/vnd.sun.xml.writer.template");
            put(".sty", "text/x-tex");
            put(".sub", "text/x-subviewer");
            put(".sun", "image/x-sun-raster");
            put(".sv4cpio", "application/x-sv4cpio");
            put(".sv4crc", "application/x-sv4crc");
            put(".svg", "image/svg+xml");
            put(".svgz", "image/svg+xml-compressed");
            put(".swf", "application/x-shockwave-flash");
            put(".sxc", "application/vnd.sun.xml.calc");
            put(".sxd", "application/vnd.sun.xml.draw");
            put(".sxg", "application/vnd.sun.xml.writer.global");
            put(".sxi", "application/vnd.sun.xml.impress");
            put(".sxm", "application/vnd.sun.xml.math");
            put(".sxw", "application/vnd.sun.xml.writer");
            put(".sylk", "text/spreadsheet");
            put(".t", "text/troff");
            put(".t2t", "text/x-txt2tags");
            put(".tar", "application/x-tar");
            put(".tar.bz", "application/x-bzip-compressed-tar");
            put(".tar.bz2", "application/x-bzip-compressed-tar");
            put(".tar.gz", "application/x-compressed-tar");
            put(".tar.lzma", "application/x-lzma-compressed-tar");
            put(".tar.lzo", "application/x-tzo");
            put(".tar.xz", "application/x-xz-compressed-tar");
            put(".tar.z", "application/x-tarz");
            put(".tbz", "application/x-bzip-compressed-tar");
            put(".tbz2", "application/x-bzip-compressed-tar");
            put(".tcl", "text/x-tcl");
            put(".tex", "text/x-tex");
            put(".texi", "text/x-texinfo");
            put(".texinfo", "text/x-texinfo");
            put(".tga", "image/x-tga");
            put(".tgz", "application/x-compressed-tar");
            put(".theme", "application/x-theme");
            put(".themepack", "application/x-windows-themepack");
            put(".tif", "image/tiff");
            put(".tiff", "image/tiff");
            put(".tk", "text/x-tcl");
            put(".tlz", "application/x-lzma-compressed-tar");
            put(".tnef", "application/vnd.ms-tnef");
            put(".tnf", "application/vnd.ms-tnef");
            put(".toc", "application/x-cdrdao-toc");
            put(".torrent", "application/x-bittorrent");
            put(".tpic", "image/x-tga");
            put(".tr", "text/troff");
            put(".ts", "application/x-linguist");
            put(".tsv", "text/tab-separated-values");
            put(".tta", "audio/x-tta");
            put(".ttc", "application/x-font-ttf");
            put(".ttf", "application/x-font-ttf");
            put(".ttx", "application/x-font-ttx");
            put(".txt", "text/plain");
            put(".txz", "application/x-xz-compressed-tar");
            put(".tzo", "application/x-tzo");
            put(".ufraw", "application/x-ufraw");
            put(".ui", "application/x-designer");
            put(".uil", "text/x-uil");
            put(".ult", "audio/x-mod");
            put(".uni", "audio/x-mod");
            put(".uri", "text/x-uri");
            put(".url", "text/x-uri");
            put(".ustar", "application/x-ustar");
            put(".vala", "text/x-vala");
            put(".vapi", "text/x-vala");
            put(".vcf", "text/directory");
            put(".vcs", "text/calendar");
            put(".vct", "text/directory");
            put(".vda", "image/x-tga");
            put(".vhd", "text/x-vhdl");
            put(".vhdl", "text/x-vhdl");
            put(".viv", "video/vivo");
            put(".vivo", "video/vivo");
            put(".vlc", "audio/x-mpegurl");
            put(".vob", "video/mpeg");
            put(".voc", "audio/x-voc");
            put(".vor", "application/vnd.stardivision.writer");
            put(".vst", "image/x-tga");
            put(".wav", "audio/x-wav");
            put(".wax", "audio/x-ms-asx");
            put(".wb1", "application/x-quattropro");
            put(".wb2", "application/x-quattropro");
            put(".wb3", "application/x-quattropro");
            put(".wbmp", "image/vnd.wap.wbmp");
            put(".wcm", "application/vnd.ms-works");
            put(".wdb", "application/vnd.ms-works");
            put(".webm", "video/webm");
            put(".wk1", "application/vnd.lotus-1-2-3");
            put(".wk3", "application/vnd.lotus-1-2-3");
            put(".wk4", "application/vnd.lotus-1-2-3");
            put(".wks", "application/vnd.ms-works");
            put(".wma", "audio/x-ms-wma");
            put(".wmf", "image/x-wmf");
            put(".wml", "text/vnd.wap.wml");
            put(".wmls", "text/vnd.wap.wmlscript");
            put(".wmv", "video/x-ms-wmv");
            put(".wmx", "audio/x-ms-asx");
            put(".wp", "application/vnd.wordperfect");
            put(".wp4", "application/vnd.wordperfect");
            put(".wp5", "application/vnd.wordperfect");
            put(".wp6", "application/vnd.wordperfect");
            put(".wpd", "application/vnd.wordperfect");
            put(".wpg", "application/x-wpg");
            put(".wpl", "application/vnd.ms-wpl");
            put(".wpp", "application/vnd.wordperfect");
            put(".wps", "application/vnd.ms-works");
            put(".wri", "application/x-mswrite");
            put(".wrl", "model/vrml");
            put(".wv", "audio/x-wavpack");
            put(".wvc", "audio/x-wavpack-correction");
            put(".wvp", "audio/x-wavpack");
            put(".wvx", "audio/x-ms-asx");
            put(".x3f", "image/x-sigma-x3f");
            put(".xac", "application/x-gnucash");
            put(".xbel", "application/x-xbel");
            put(".xbl", "application/xml");
            put(".xbm", "image/x-xbitmap");
            put(".xcf", "image/x-xcf");
            put(".xcf.bz2", "image/x-compressed-xcf");
            put(".xcf.gz", "image/x-compressed-xcf");
            put(".xhtml", "application/xhtml+xml");
            put(".xi", "audio/x-xi");
            put(".xla", "application/vnd.ms-excel");
            put(".xlc", "application/vnd.ms-excel");
            put(".xld", "application/vnd.ms-excel");
            put(".xlf", "application/x-xliff");
            put(".xliff", "application/x-xliff");
            put(".xll", "application/vnd.ms-excel");
            put(".xlm", "application/vnd.ms-excel");
            put(".xls", "application/vnd.ms-excel");
            put(".xlsm", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            put(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            put(".xlt", "application/vnd.ms-excel");
            put(".xlw", "application/vnd.ms-excel");
            put(".xm", "audio/x-xm");
            put(".xmf", "audio/x-xmf");
            put(".xmi", "text/x-xmi");
            put(".xml", "application/xml");
            put(".xpm", "image/x-xpixmap");
            put(".xps", "application/vnd.ms-xpsdocument");
            put(".xsl", "application/xml");
            put(".xslfo", "text/x-xslfo");
            put(".xslt", "application/xml");
            put(".xspf", "application/xspf+xml");
            put(".xul", "application/vnd.mozilla.xul+xml");
            put(".xwd", "image/x-xwindowdump");
            put(".xyz", "chemical/x-pdb");
            put(".xz", "application/x-xz");
            put(".w2p", "application/w2p");
            put(".z", "application/x-compress");
            put(".zabw", "application/x-abiword");
            put(".zip", "application/zip");
        }
    };
}
