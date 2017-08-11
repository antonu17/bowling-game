package org.antonu.bowling.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Round
 */

public class Round {
    @JsonProperty("balls")
    private List<Integer> balls = new ArrayList<Integer>();

    @JsonProperty("score")
    private Integer score = null;

    public Round balls(List<Integer> balls) {
        this.balls = balls;
        return this;
    }

    public Round addBallsItem(Integer ballsItem) {
        this.balls.add(ballsItem);
        return this;
    }

    /**
     * Get balls
     *
     * @return balls
     **/
    @ApiModelProperty(required = true, value = "")
    public List<Integer> getBalls() {
        return balls;
    }

    public void setBalls(List<Integer> balls) {
        this.balls = balls;
    }

    public Round score(Integer score) {
        this.score = score;
        return this;
    }

    /**
     * Game score round
     *
     * @return score
     **/
    @ApiModelProperty(required = true, value = "Game score round")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round = (Round) o;
        return Objects.equals(this.balls, round.balls) &&
                Objects.equals(this.score, round.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, score);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Round {\n");

        sb.append("    balls: ").append(toIndentedString(balls)).append("\n");
        sb.append("    score: ").append(toIndentedString(score)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

