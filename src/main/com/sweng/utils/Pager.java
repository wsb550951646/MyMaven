package sweng.utils;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/614:21
 */
public class Pager {
    private int pageIndex = 1;
    private int pageSize = 15;
    private long totalRows;
    private List result;

    public Pager() {
    }

    public Pager(int pageIndex, int pageSize, long totalRows, List result) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.result = result;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotalRows() {
        return this.totalRows;
    }

    //总的记录 / pagesize 为总的页数。若有除余大于0 count数加1
    public int getPageCount() {
        if (this.pageSize < 0) {
            return 0;
        } else {
            int count = (int)(this.totalRows / (long)this.pageSize);
            if (this.totalRows % (long)this.pageSize > 0L) {
                ++count;
            }

            return count;
        }
    }

    public Integer getPreviousPage() {
        int count = this.getPageCount();
        if (count <= 1) {
            return null;
        } else {
            return this.pageIndex <= 1 ? null : this.pageIndex - 1;
        }
    }

    public Integer getNextPage() {
        int count = this.getPageCount();
        if (count <= 1) {
            return null;
        } else {
            return this.pageIndex >= count ? null : this.pageIndex + 1;
        }
    }

    public List getResult() {
        return this.result;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
