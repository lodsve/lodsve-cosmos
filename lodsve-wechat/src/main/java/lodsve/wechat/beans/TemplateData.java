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

package lodsve.wechat.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 模板消息的数据.
 *
 * @author sunhao(sunhao.java @ gmail.com)
 * @version V1.0, 16/2/24 下午4:24
 */
@ApiModel(description = "模板消息的数据")
public class TemplateData {
    @ApiModelProperty(value = "键", required = true)
    private String key;
    @ApiModelProperty(value = "值", required = true)
    private String value;
    @ApiModelProperty(value = "文字颜色", required = true)
    private String color;

    @ApiModelProperty(value = "键", required = true)
    public String getKey() {
        return key;
    }

    @ApiModelProperty(value = "键", required = true)
    public void setKey(String key) {
        this.key = key;
    }

    @ApiModelProperty(value = "值", required = true)
    public String getValue() {
        return value;
    }

    @ApiModelProperty(value = "值", required = true)
    public void setValue(String value) {
        this.value = value;
    }

    @ApiModelProperty(value = "文字颜色", required = true)
    public String getColor() {
        return color;
    }

    @ApiModelProperty(value = "文字颜色", required = true)
    public void setColor(String color) {
        this.color = color;
    }
}
