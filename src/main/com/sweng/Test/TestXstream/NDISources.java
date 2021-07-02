package sweng.Test.TestXstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/9/1017:02
 */


@XStreamAlias("NDISources")
public class NDISources {

    public NDISources() {
    }

    public NDISources(List<Source> sources) {
        this.sources = sources;
    }

    @XStreamImplicit(itemFieldName = "Source")
    private List<Source> sources;


    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }


}
