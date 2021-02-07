package org.dibek.munro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public class MunroInfo {

    public static final String DLM = ";";
    @JsonIgnore  @CsvBindByName(column = "Running No")
    private Long runningNo;
    @JsonIgnore  @CsvBindByName(column = "DoBIH Number")
    private Long doBIHNumber;
    @JsonIgnore  @CsvBindByName(column = "Streetmap")
    private String streetMapUrl;
    @JsonIgnore  @CsvBindByName(column = "Geograph")
    private String geographUrl;
    @JsonIgnore  @CsvBindByName(column = "Hill-bagging")
    private String hillBagging;
    @CsvBindByName(column = "Name")
    private String name;
    @JsonIgnore  @CsvBindByName(column = "SMC Section")
    private Integer smcSection;
    @JsonIgnore  @CsvBindByName(column = "RHB Section")
    private String rhbSection;
    @JsonIgnore  @CsvBindByName(column = "_Section")
    private String section;
    @CsvBindByName(column = "Height (m)")
    private BigDecimal heightMeter;
    @JsonIgnore  @CsvBindByName(column = "Height (ft)")
    private BigDecimal heightFeet;
    @JsonIgnore  @CsvBindByName(column = "Map 1:50")
    private String map1To50;
    @JsonIgnore  @CsvBindByName(column = "Map 1:25")
    private String map1To25;
    @CsvBindByName(column = "Grid Ref")
    private String gridRef;
    @JsonIgnore  @CsvBindByName(column = "GridRefXY")
    private String gridRefXY;
    @JsonIgnore  @CsvBindByName(column = "xcoord")
    private Integer xCoord;
    @JsonIgnore  @CsvBindByName(column = "ycoord")
    private Integer yCoord;
    @JsonIgnore  @CsvBindByName(column = "1891")
    private String y1891;
    @JsonIgnore  @CsvBindByName(column = "1921")
    private String y1921;
    @JsonIgnore  @CsvBindByName(column = "1933")
    private String y1933;
    @JsonIgnore  @CsvBindByName(column = "1953")
    private String y1953;
    @JsonIgnore  @CsvBindByName(column = "1969")
    private String y1969;
    @JsonIgnore  @CsvBindByName(column = "1974")
    private String y1974;
    @JsonIgnore  @CsvBindByName(column = "1981")
    private String y1981;
    @JsonIgnore  @CsvBindByName(column = "1984")
    private String y1984;
    @JsonIgnore  @CsvBindByName(column = "1990")
    private String y1990;
    @JsonIgnore  @CsvBindByName(column = "1997")
    private String y1997;
    @JsonIgnore  @CsvBindByName(column = "Post 1997")
    private String yPost1997;
    @JsonIgnore  @CsvBindByName(column = "Comments")
    private String comments;


    private String category;

    @JsonIgnore
    private BigDecimal minHeight;

    @JsonIgnore
    private BigDecimal maxHeight;



    public Long getRunningNo() {
        return runningNo;
    }

    public Long getDoBIHNumber() {
        return doBIHNumber;
    }

    public String getStreetMapUrl() {
        return streetMapUrl;
    }

    public String getGeographUrl() {
        return geographUrl;
    }

    public String getHillBagging() {
        return hillBagging;
    }

    public String getName() {
        return name;
    }

    public Integer getSmcSection() {
        return smcSection;
    }

    public String getRhbSection() {
        return rhbSection;
    }

    public String getSection() {
        return section;
    }

    public BigDecimal getHeightMeter() {
        return heightMeter;
    }

    public BigDecimal getHeightFeet() {
        return heightFeet;
    }

    public String getMap1To50() {
        return map1To50;
    }

    public String getMap1To25() {
        return map1To25;
    }

    public String getGridRef() {
        return gridRef;
    }

    public String getGridRefXY() {
        return gridRefXY;
    }

    public Integer getxCoord() {
        return xCoord;
    }

    public Integer getyCoord() {
        return yCoord;
    }

    public String getY1891() {
        return y1891;
    }

    public String getY1921() {
        return y1921;
    }

    public String getY1933() {
        return y1933;
    }

    public String getY1953() {
        return y1953;
    }

    public String getY1969() {
        return y1969;
    }

    public String getY1974() {
        return y1974;
    }

    public String getY1981() {
        return y1981;
    }

    public String getY1984() {
        return y1984;
    }

    public String getY1990() {
        return y1990;
    }

    public String getY1997() {
        return y1997;
    }

    public String getyPost1997() {
        return yPost1997;
    }

    public String getComments() {
        return comments;
    }

    public String getCategory() {
        return this.category != null? this.category:
                calculateCategory()
                ;
    }

    private String calculateCategory() {
        String category = "";
        category =  this.y1921 + DLM +
                this.y1891 + DLM +
                this.y1933 + DLM +
                this.y1953 + DLM +
                this.y1969 + DLM +
                this.y1974 + DLM +
                this.y1981 + DLM +
                this.y1984 + DLM +
                this.y1990 + DLM +
                this.y1997 + DLM +
                this.yPost1997;
        return category.toUpperCase().contains("TOP") ? "TOP": category.toUpperCase().contains("MUN") ? "MUN": "";
    }


    public BigDecimal getMinHeight() {
        return minHeight;
    }

    public BigDecimal getMaxHeight() {
        return maxHeight;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MunroInfo munroInfo = (MunroInfo) o;
        return Objects.equals(runningNo, munroInfo.runningNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runningNo);
    }


    public static final class MunroInfoBuilder {
        private Long runningNo;
        private Long doBIHNumber;
        private String streetMapUrl;
        private String geographUrl;
        private String hillBagging;
        private String name;
        private Integer smcSection;
        private String rhbSection;
        private String section;
        private BigDecimal heightMeter;
        private BigDecimal heightFeet;
        private String map1To50;
        private String map1To25;
        private String gridRef;
        private String gridRefXY;
        private Integer xCoord;
        private Integer yCoord;
        private String y1891;
        private String y1921;
        private String y1933;
        private String y1953;
        private String y1969;
        private String y1974;
        private String y1981;
        private String y1984;
        private String y1990;
        private String y1997;
        private String yPost1997;
        private String comments;
        private String category;
        private BigDecimal minHeight;
        private BigDecimal maxHeight;

        private MunroInfoBuilder() {
        }

        public static MunroInfoBuilder aMunroInfo() {
            return new MunroInfoBuilder();
        }

        public MunroInfoBuilder withRunningNo(Long runningNo) {
            this.runningNo = runningNo;
            return this;
        }

        public MunroInfoBuilder withDoBIHNumber(Long doBIHNumber) {
            this.doBIHNumber = doBIHNumber;
            return this;
        }

        public MunroInfoBuilder withStreetMapUrl(String streetMapUrl) {
            this.streetMapUrl = streetMapUrl;
            return this;
        }

        public MunroInfoBuilder withGeographUrl(String geographUrl) {
            this.geographUrl = geographUrl;
            return this;
        }

        public MunroInfoBuilder withHillBagging(String hillBagging) {
            this.hillBagging = hillBagging;
            return this;
        }

        public MunroInfoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MunroInfoBuilder withSmcSection(Integer smcSection) {
            this.smcSection = smcSection;
            return this;
        }

        public MunroInfoBuilder withRhbSection(String rhbSection) {
            this.rhbSection = rhbSection;
            return this;
        }

        public MunroInfoBuilder withSection(String section) {
            this.section = section;
            return this;
        }

        public MunroInfoBuilder withHeightMeter(BigDecimal heightMeter) {
            this.heightMeter = heightMeter;
            return this;
        }

        public MunroInfoBuilder withHeightFeet(BigDecimal heightFeet) {
            this.heightFeet = heightFeet;
            return this;
        }

        public MunroInfoBuilder withMap1To50(String map1To50) {
            this.map1To50 = map1To50;
            return this;
        }

        public MunroInfoBuilder withMap1To25(String map1To25) {
            this.map1To25 = map1To25;
            return this;
        }

        public MunroInfoBuilder withGridRef(String gridRef) {
            this.gridRef = gridRef;
            return this;
        }

        public MunroInfoBuilder withGridRefXY(String gridRefXY) {
            this.gridRefXY = gridRefXY;
            return this;
        }

        public MunroInfoBuilder withXCoord(Integer xCoord) {
            this.xCoord = xCoord;
            return this;
        }

        public MunroInfoBuilder withYCoord(Integer yCoord) {
            this.yCoord = yCoord;
            return this;
        }

        public MunroInfoBuilder withY1891(String y1891) {
            this.y1891 = y1891;
            return this;
        }

        public MunroInfoBuilder withY1921(String y1921) {
            this.y1921 = y1921;
            return this;
        }

        public MunroInfoBuilder withY1933(String y1933) {
            this.y1933 = y1933;
            return this;
        }

        public MunroInfoBuilder withY1953(String y1953) {
            this.y1953 = y1953;
            return this;
        }

        public MunroInfoBuilder withY1969(String y1969) {
            this.y1969 = y1969;
            return this;
        }

        public MunroInfoBuilder withY1974(String y1974) {
            this.y1974 = y1974;
            return this;
        }

        public MunroInfoBuilder withY1981(String y1981) {
            this.y1981 = y1981;
            return this;
        }

        public MunroInfoBuilder withY1984(String y1984) {
            this.y1984 = y1984;
            return this;
        }

        public MunroInfoBuilder withY1990(String y1990) {
            this.y1990 = y1990;
            return this;
        }

        public MunroInfoBuilder withY1997(String y1997) {
            this.y1997 = y1997;
            return this;
        }

        public MunroInfoBuilder withYPost1997(String yPost1997) {
            this.yPost1997 = yPost1997;
            return this;
        }

        public MunroInfoBuilder withComments(String comments) {
            this.comments = comments;
            return this;
        }

        public MunroInfoBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public MunroInfoBuilder withMinHeight(BigDecimal minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public MunroInfoBuilder withMaxHeight(BigDecimal maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public MunroInfo build() {
            MunroInfo munroInfo = new MunroInfo();
            munroInfo.y1953 = this.y1953;
            munroInfo.minHeight = this.minHeight;
            munroInfo.rhbSection = this.rhbSection;
            munroInfo.runningNo = this.runningNo;
            munroInfo.y1974 = this.y1974;
            munroInfo.comments = this.comments;
            munroInfo.gridRef = this.gridRef;
            munroInfo.y1891 = this.y1891;
            munroInfo.geographUrl = this.geographUrl;
            munroInfo.y1984 = this.y1984;
            munroInfo.map1To50 = this.map1To50;
            munroInfo.yCoord = this.yCoord;
            munroInfo.y1997 = this.y1997;
            munroInfo.map1To25 = this.map1To25;
            munroInfo.y1990 = this.y1990;
            munroInfo.hillBagging = this.hillBagging;
            munroInfo.y1933 = this.y1933;
            munroInfo.category = this.category;
            munroInfo.streetMapUrl = this.streetMapUrl;
            munroInfo.maxHeight = this.maxHeight;
            munroInfo.y1921 = this.y1921;
            munroInfo.y1981 = this.y1981;
            munroInfo.section = this.section;
            munroInfo.gridRefXY = this.gridRefXY;
            munroInfo.xCoord = this.xCoord;
            munroInfo.heightMeter = this.heightMeter;
            munroInfo.y1969 = this.y1969;
            munroInfo.heightFeet = this.heightFeet;
            munroInfo.name = this.name;
            munroInfo.smcSection = this.smcSection;
            munroInfo.doBIHNumber = this.doBIHNumber;
            munroInfo.yPost1997 = this.yPost1997;
            return munroInfo;
        }
    }
}
