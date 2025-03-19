package es.upm.miw.apaw_practice.adapters.rest.shop;

import es.upm.miw.apaw_practice.domain.models.shop.Article;

public class BasicArticleDto {

    private String barcode;
    private String summary;

    public BasicArticleDto() {
        // empty for framework
    }

    public BasicArticleDto(Article article) {
        this.barcode = article.getBarcode();
        this.summary = article.getSummary();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "BasicArticleDto [barcode=" + barcode + ", summary=" + summary + "]";
    }

}
