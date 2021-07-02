package sweng.Test.TestXstream.mediaInfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@XStreamAlias("mediaInfo")
public class MediaInfo {
    @XStreamAlias("container")
    private String container;
    private long size;
    private int programsSize;
    @XStreamImplicit(itemFieldName = "programs")
    private List<Program> programs;

    @XStreamAlias("video")
    private Video video;

    @XStreamAlias("audio")
    private Audio audio;

    @XStreamAlias("subtitle")
    private Subtitle subtitle;
    private long duration = 0;

    public long getDurationInfo() {
        long ret = duration;
        if (duration <= 0) {
            if (programsSize > 0) {
                try {
                    if (programs.get(0).getVideos().size() > 0) {
                        ret = Long.parseLong(programs.get(0).getVideos().get(0).getDuration());
                    } else if (programs.get(0).getAudios().size() > 0) {
                        ret = Long.parseLong(programs.get(0).getAudios().get(0).getDuration());
                    }
                } catch (Exception e) {
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "MediaInfo{" +
                "container='" + container + '\'' +
                ", size=" + size +
                ", programsSize=" + programsSize +
                ", programs=" + programs +
                ", video=" + video +
                ", audio=" + audio +
                ", subtitle=" + subtitle +
                ", duration=" + duration +
                '}';
    }
}
