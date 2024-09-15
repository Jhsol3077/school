package com.common;

public class SearchCondition {

    // 필드 선언
    private String option; // 검색 조건
    private String value;  // 검색어

    // 1. 기본 생성자
    public SearchCondition() {
    }

    // 2. 모든 필드를 초기화하는 생성자
    public SearchCondition(String option, String value) {
        this.option = option;
        this.value = value;
    }

    // 3. Getter와 Setter
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 4. toString() 메서드
    @Override
    public String toString() {
        return "SearchCondition{" +
                "option='" + option + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // 5. equals()와 hashCode() 메서드 (DTO 객체 비교 시 유용)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchCondition that = (SearchCondition) o;

        if (!option.equals(that.option)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = option.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
