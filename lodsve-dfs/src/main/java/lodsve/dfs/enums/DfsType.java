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

package lodsve.dfs.enums;

import lodsve.dfs.service.DfsService;
import lodsve.dfs.service.impl.FastDfsServiceImpl;
import lodsve.dfs.service.impl.GoogleFsServiceImpl;
import lodsve.dfs.service.impl.NormalDfsServiceImpl;
import lodsve.dfs.service.impl.TfsServiceImpl;

/**
 * 使用的文件系统类型.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2017-12-4-0004 10:41
 */
public enum DfsType {
    /**
     * fast_dfs
     */
    FAST_DFS(FastDfsServiceImpl.class),
    /**
     * tfs
     */
    TFS(TfsServiceImpl.class),
    /**
     * GoogleFS
     */
    GOOGLE_FS(GoogleFsServiceImpl.class),
    /**
     * 保存在本地服务器
     */
    NORMAL(NormalDfsServiceImpl.class);

    private Class<? extends DfsService> implClazz;

    DfsType(Class<? extends DfsService> implClazz) {
        this.implClazz = implClazz;
    }

    public Class<? extends DfsService> getImplClazz() {
        return implClazz;
    }
}
