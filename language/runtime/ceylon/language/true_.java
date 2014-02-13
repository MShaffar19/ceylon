package ceylon.language;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.Object;

@Ceylon(major = 6) @Object
public final class true_ extends Boolean {
    
    private final static true_ value = new true_();

    public static true_ get_(){
        return value;
    }

    @Override
    @Ignore
    public boolean booleanValue() {
        return true;
    }
    
    @Override
    public java.lang.String toString() {
        return "true";
    }
}
