import groovy.transform.CompileStatic
import java.text.SimpleDateFormat

@CompileStatic
class TimeStamp {
    static final BUILD_START = new Date()
    static final String OSGI_TIMESTAMP = {
        SimpleDateFormat df = new SimpleDateFormat ("yyyyMMdd-HHmm")
        df.timeZone = TimeZone.getTimeZone("GMT");
        return df.format (BUILD_START)
    }.call()
    static final String DSTAMP = {
        SimpleDateFormat df = new SimpleDateFormat ("yyyyMMdd")
        return df.format (BUILD_START)
    }.call()
    static final String NOW = {
        SimpleDateFormat df = new SimpleDateFormat ("yyyyMMddHHmm")
        return df.format (BUILD_START)
    }.call()
    static final String TODAY = {
        SimpleDateFormat df = new SimpleDateFormat ("MMM dd yyyy")
        return df.format (BUILD_START)
    }.call()
    static final String TSTAMP = {
        SimpleDateFormat df = new SimpleDateFormat ("HHmm")
        return df.format (BUILD_START)
    }.call()
}
