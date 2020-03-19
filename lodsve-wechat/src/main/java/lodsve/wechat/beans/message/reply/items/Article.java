/*
 * Copyright (C) 2019 Sun.Hao(https://www.crazy-coder.cn/)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package lodsve.wechat.beans.message.reply.items;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图文消息中的文章.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 16/2/23 下午11:43
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Article {
    @XmlElement(name = "Title")
    @JSONField(name = "Title")
    public String title;
    @XmlElement(name = "Description")
    @JSONField(name = "Description")
    public String description;
    @XmlElement(name = "PicUrl")
    @JSONField(name = "PicUrl")
    public String picUrl;
    @XmlElement(name = "Url")
    @JSONField(name = "Url")
    public String url;
}
