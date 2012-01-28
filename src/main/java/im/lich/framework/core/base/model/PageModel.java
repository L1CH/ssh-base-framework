package im.lich.framework.core.base.model;

/**
 * @author: Ethan
 */
public class PageModel {

	/** 当前页码 */
	private int currentPage = 1;
	/** 页码总数 */
	public int totalPages = 0;
	/** 每页记录 */
	private int pageRecords = 20;
	/** 总记录数 */
	private int totalRecords = 0;
	/** 开始记录 */
	private int startRecord = 0;
	/** 下一页 */
	private int nextPage = 0;
	/** 上一页 */
	private int previousPage = 0;
	/** 是否有下一页 */
	private boolean hasNextPage = false;
	/** 是否有前一页 */
	private boolean hasPreviousPage = false;

	public PageModel(int pageRecords, int currentPage, int totalRecords) {
		this.pageRecords = pageRecords;
		this.currentPage = currentPage;
		this.totalRecords = totalRecords;

		if ((totalRecords % pageRecords) == 0) {
			totalPages = totalRecords / pageRecords;
		} else {
			totalPages = totalRecords / pageRecords + 1;
		}

		if (currentPage >= totalPages) {
			hasNextPage = false;
			currentPage = totalPages;
		} else {
			hasNextPage = true;
		}

		if (currentPage <= 1) {
			hasPreviousPage = false;
			currentPage = 1;
		} else {
			hasPreviousPage = true;
		}

		startRecord = (currentPage - 1) * pageRecords;

		nextPage = currentPage + 1;

		if (nextPage >= totalPages) {
			nextPage = totalPages;
		}

		previousPage = currentPage - 1;

		if (previousPage <= 1) {
			previousPage = 1;
		}

	}

	public boolean isHasNextPage() {

		return hasNextPage;

	}

	public boolean isHasPreviousPage() {

		return hasPreviousPage;

	}

	/**
	 * @return the nextPage
	 */
	public int getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage
	 *            the nextPage to set
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * @return the previousPage
	 */
	public int getPreviousPage() {
		return previousPage;
	}

	/**
	 * @param previousPage
	 *            the previousPage to set
	 */
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageRecords
	 */
	public int getPageRecords() {
		return pageRecords;
	}

	/**
	 * @param pageRecords the pageRecords to set
	 */
	public void setPageRecords(int pageRecords) {
		this.pageRecords = pageRecords;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords
	 *            the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @param hasNextPage
	 *            the hasNextPage to set
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	/**
	 * @param hasPreviousPage
	 *            the hasPreviousPage to set
	 */
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	/**
	 * @return the startRecord
	 */
	public int getStartRecord() {
		return startRecord;
	}

	/**
	 * @param startRecord the startRecord to set
	 */
	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
}
