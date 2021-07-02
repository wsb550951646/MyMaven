package sweng.Test.TestXstream.mediaInfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("subtitle")
public class Subtitle {
    private int pid;
    private String name;
    private String language;
    private String used;
}
