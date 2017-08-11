package org.antonu.bowling.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Game
 */
public class Game implements Serializable {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("finished")
    private Boolean finished = null;

    @JsonProperty("totalScore")
    private Integer totalScore = null;

    @JsonProperty("rounds")
    private List<Round> rounds = new ArrayList<Round>();

    public Game id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Game ID
     *
     * @return id
     **/
    @ApiModelProperty(required = true, value = "Game ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Game finished(Boolean finished) {
        this.finished = finished;
        return this;
    }

    /**
     * Game is finished flag
     *
     * @return finished
     **/
    @ApiModelProperty(required = true, value = "Game is finished flag")
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Game totalScore(Integer totalScore) {
        this.totalScore = totalScore;
        return this;
    }

    /**
     * Game total score
     *
     * @return totalScore
     **/
    @ApiModelProperty(required = true, value = "Game total score")
    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Game rounds(List<Round> rounds) {
        this.rounds = rounds;
        return this;
    }

    public Game addRoundsItem(Round roundsItem) {
        this.rounds.add(roundsItem);
        return this;
    }

    /**
     * Get rounds
     *
     * @return rounds
     **/
    @ApiModelProperty(required = true, value = "")
    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return Objects.equals(this.id, game.id) &&
                Objects.equals(this.finished, game.finished) &&
                Objects.equals(this.totalScore, game.totalScore) &&
                Objects.equals(this.rounds, game.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, finished, totalScore, rounds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Game {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    finished: ").append(toIndentedString(finished)).append("\n");
        sb.append("    totalScore: ").append(toIndentedString(totalScore)).append("\n");
        sb.append("    rounds: ").append(toIndentedString(rounds)).append("\n");
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

