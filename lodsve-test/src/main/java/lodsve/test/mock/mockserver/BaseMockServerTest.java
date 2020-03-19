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

package lodsve.test.mock.mockserver;

import lodsve.test.mock.powermock.BasePowerMockitoTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.socket.PortFactory;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

/**
 * 使用mockserver的基类.<br/>
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 16-3-10 12:34
 */
@PowerMockIgnore("javax.net.ssl.*")
public class BaseMockServerTest extends BasePowerMockitoTest {
    protected static ClientAndServer mockServer;
    /**
     * 基础url，如http://localhost:8080
     */
    protected static String baseUrl;

    @BeforeClass
    public static void startServer() throws Exception {
        int port = PortFactory.findFreePort();
        System.out.println("port is " + port);
        mockServer = ClientAndServer.startClientAndServer(port);
        baseUrl = "http://localhost:" + port;
    }

    @AfterClass
    public static void stopServer() {
        if (mockServer != null) {
            mockServer.stop();
        }

        baseUrl = "";
    }
}
