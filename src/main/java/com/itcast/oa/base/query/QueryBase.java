package com.itcast.oa.base.query;

import com.itcast.oa.base.exception.BizServiceException;
import com.itcast.oa.base.util.StringUtil;

import java.util.List;
import java.util.regex.Pattern;

public class QueryBase<T> {
	
    private Integer page = 1;

    private Integer start = 0;

    private Integer limit = 10;
    
    private boolean jqGrid = false;

    private Integer totalCount;// 总条数

    private Integer pages;// 总页数

    private List<T> items;// 查询结果

    private String orderColumn;// 分页字段

    private String orderDir;// 分页方向

    static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

    static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    public Integer getStart() {
    	if(jqGrid){
    		start = (page - 1) * limit;
    	}
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.pages = (totalCount + limit - 1) / limit;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        if (StringUtil.isEmpty(orderColumn)) {
            orderColumn = getDefaultOrderColumn();
        } else {
            if (sqlPattern.matcher(orderColumn).find()) {

                throw new BizServiceException("-1", "不支持该排序参数" + orderColumn);
            }
        }
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        if (StringUtil.isEmpty(orderDir)) {
            orderDir = "DESC";
        } else {
            if (orderDir.equalsIgnoreCase("DESC")
                    || orderDir.equalsIgnoreCase("ASC")) {
                orderDir = orderDir.toUpperCase();
            } else {
                throw new BizServiceException("-1", "非法排序参数" + orderDir);
            }
        }
        this.orderDir = orderDir;
    }

    public String getDefaultOrderColumn() {
        return orderColumn;
    }

	public boolean isJqGrid() {
		return jqGrid;
	}

	public void setJqGrid(boolean jqGrid) {
		this.jqGrid = jqGrid;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
