package sweng.Test.TestXstream.mediaInfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@XStreamAlias("program")
public class Program {
    private int pid;
    private String name;
    private String used;
    private int videoSize;
    private int audioSize;
    private int subtitleSize;
    @XStreamImplicit(itemFieldName = "videos")
    private List<Video> videos;
    @XStreamImplicit(itemFieldName = "audios")
    private List<Audio> audios;
    @XStreamImplicit(itemFieldName = "subtitles")
    private List<Subtitle> subtitles;
}
