package generic.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huiyh on 2017/10/27.
 */

public class WordEntity {

    /**
     * word : 北京好找北京工作吗
     * position : [{"pos":0,"len":1},{"pos":4,"len":1}]
     */

    @SerializedName("word")
    private String word;
    @SerializedName("position")
    private List<PositionBean> position;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<PositionBean> getPosition() {
        return position;
    }

    public void setPosition(List<PositionBean> position) {
        this.position = position;
    }

    public static class PositionBean {
        /**
         * pos : 0
         * len : 1
         */

        @SerializedName("pos")
        private int pos;
        @SerializedName("len")
        private int len;

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }
}
