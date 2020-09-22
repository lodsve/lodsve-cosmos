/*
 * Copyright © 2009 Sun.Hao(https://www.crazy-coder.cn/)
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lodsve.wechat.beans.tidings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lodsve.wechat.beans.tidings.items.Video;

/**
 * 视频客服消息.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 16/2/24 下午12:01
 */
@ApiModel(description = "视频客服消息")
public class VideoTidings extends Tidings {
    public VideoTidings() {
        setTidingsType(TidingsType.video);
    }

    @ApiModelProperty(value = "视频", required = true)
    private Video video;

    @ApiModelProperty(value = "视频", required = true)
    public Video getVideo() {
        return video;
    }

    @ApiModelProperty(value = "视频", required = true)
    public void setVideo(Video video) {
        this.video = video;
    }
}
