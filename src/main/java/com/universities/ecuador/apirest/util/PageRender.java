package com.universities.ecuador.apirest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;

	private Page<T> page;

	private int totalPages;

	private int numElementsByPage;

	private int pageCurrent;

	private List<PageItem> pages;

	public PageRender(String url, Page<T> page, int numElementByPage) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();

		this.numElementsByPage = numElementByPage;
		
		totalPages = page.getTotalPages();
		pageCurrent = page.getNumber() + 1;

		int from, to;
		if (totalPages <= numElementsByPage) {
			from = 1;
			to = totalPages;
		} else {
			if (pageCurrent <= numElementsByPage / 2) {
				from = 1;
				to = numElementsByPage;
			} else if (pageCurrent >= totalPages - numElementsByPage / 2) {
				from = totalPages - numElementsByPage + 1;
				to = numElementsByPage;
			} else {
				from = pageCurrent - numElementsByPage / 2;
				to = numElementsByPage;
			}
		}

		for (int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, pageCurrent == from + i));
		}

	}

	public String getUrl() {
		return url;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

}
