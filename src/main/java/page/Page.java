package page;

/**
 * 简单分页
 */
public class Page {
    private Integer pageNum; //页号
    private Integer pageSize;//页面数据大小
    private Integer offset; //偏移量，即从哪条查起

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    //offset 的get方法计算偏移量
    public Integer getOffset() {
        return (pageNum-1)*pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
