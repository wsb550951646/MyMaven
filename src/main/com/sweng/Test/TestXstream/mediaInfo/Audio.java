package sweng.Test.TestXstream.mediaInfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("audio")
public class Audio {
    private int pid;
    private String name;
    private String language;
    private String used;
    private String codec;
    private String duration;
    private String bitrate;
    private String channel;
    @XStreamAlias("samplerate")
    private String sampleRate;
    @XStreamAlias("bitdepth")
    private String bitDepth;
}
