package sweng.Test.TestXstream.mediaInfo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MediaInfoQuery implements Serializable {
    private static final long serialVersionUID = -1332027460110551776L;

    private String uri;
    private String uriType;
    private String bindingNI;
    private String type;
    private Integer groupId;
    //private NdiUri ndiUri;
}
