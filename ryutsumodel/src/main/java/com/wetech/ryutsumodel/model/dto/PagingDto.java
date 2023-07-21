package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class PagingDto {
    /**
     * 総ページ数
     */
    private int totalPageCount;
    /**
     * データ総件数
     */
    private int totalDataCount;
    /**
     * ページ位置
     */
    private int currentPage;
}
