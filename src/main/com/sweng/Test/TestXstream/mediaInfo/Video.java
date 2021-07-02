package sweng.Test.TestXstream.mediaInfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("video")
public class Video {
    private int pid;

    private String name;
    private String used;
    private String codec;
    private String duration;
    private String bitrate;
    @XStreamAlias("framerate")
    private String frameRate;
    private String resolution;

    @XStreamAlias("aspectratio")
    private String aspectRatio;

    private String rotation;

    @XStreamAlias("bitratemode")
    private String bitrateMode;
}
