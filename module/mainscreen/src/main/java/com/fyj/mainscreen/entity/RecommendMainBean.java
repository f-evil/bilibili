package com.fyj.mainscreen.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 当前作者: Fyj<br>
 * 时间: 2017/7/7<br>
 * 邮箱: f279259625@gmail.com<br>
 * 修改次数: <br>
 * 描述:
 */

public class RecommendMainBean implements Serializable {

    /**
     * type : recommend
     * head : {"param":"","goto":"","style":"gm_av","title":"热门焦点"}
     * body : [{"title":"【终末完结纪念MAD】因为我是世界上最幸福的女孩","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/de4568122286c2babe0ff6a3f66f1c6325b7d17c.jpg","param":"11841947","goto":"av","width":350,"height":219,"play":"9.6万","danmaku":"1630","up":"喵派"},{"title":"【手书】【戴亚】东京夏日相会","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/185b3fea303d6db49dc29c39ee5f84aa0fbf6598.jpg","param":"11797141","goto":"av","width":350,"height":219,"play":"4.0万","danmaku":"740","up":"小陆大法好"},{"title":"【手書】不/完/全/正/解/：/界/外/科/學","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/3d49a02f13261ca2df16a5e83aa645f7e966c6a6.jpg","param":"11804919","goto":"av","width":350,"height":219,"play":"5.7万","danmaku":"623","up":"萬象F5鍵"},{"title":"【Lex】简直神作！2017上半年最神奇的动画！","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/80e691dd4fa586a947d3668e4e6f7dce89a6eef8.jpg","param":"11954031","goto":"av","width":350,"height":219,"play":"35.6万","danmaku":"2.0万","up":"LexBurner"}]
     */

    private String type;
    private RecommendHeadBean head;
    private List<RecommendBodyBean> body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RecommendHeadBean getHead() {
        return head;
    }

    public void setHead(RecommendHeadBean head) {
        this.head = head;
    }

    public List<RecommendBodyBean> getBody() {
        return body;
    }

    public void setBody(List<RecommendBodyBean> body) {
        this.body = body;
    }

}
