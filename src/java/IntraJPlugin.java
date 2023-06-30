/* Copyright (c) 2021, Idriss Riouak <idriss.riouak@cs.lth.se>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.extendj;

import com.ibm.wala.classLoader.Module;
import com.ibm.wala.classLoader.SourceFileModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashSet;
import magpiebridge.core.AnalysisResult;
import magpiebridge.core.IProjectService;
import magpiebridge.core.MagpieServer;
import magpiebridge.core.ServerAnalysis;
import magpiebridge.core.ServerConfiguration;
import magpiebridge.core.ToolAnalysis;
import magpiebridge.projectservice.java.JavaProjectService;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.extendj.analysis.Analysis;
import org.extendj.ast.CompilationUnit;
import org.extendj.ast.Program;
import org.extendj.magpiebridge.CodeAnalysis;
import org.extendj.magpiebridge.StaticServerAnalysis;


/**
 * Perform static semantic checks on a Java program.
 */
public class IntraJPlugin {
  private static StaticServerAnalysis serverAnalysis =
      new StaticServerAnalysis();

  public static MagpieServer server;

  

  /**
   * Entry point for the Java checker.
   * @param args command-line arguments
   */
  public static void main(String args[])
      throws FileNotFoundException, InterruptedException, IOException {
      createServer().launchOnStdio();
  }

  

    
   /**
     * Creates and configures a new instance of the MagpieServer.
     *
     * @return The configured MagpieServer instance.
     */
  private static MagpieServer createServer() {
      ServerConfiguration config = new ServerConfiguration();
      config.setDoAnalysisBySave(true);
      config.setDoAnalysisByFirstOpen(true);
      config.setDoAnalysisByOpen(true);
      config.setShowConfigurationPage(false, false);
      config.setUseMagpieHTTPServer(false);

      server = new MagpieServer(config);

      String language = "java";
      IProjectService javaProjectService = new JavaProjectService();
      server.addProjectService(language, javaProjectService);
      Either<ServerAnalysis, ToolAnalysis> analysis = Either.forLeft(serverAnalysis);
      server.addAnalysis(analysis, language);
      return server;
  }


  


}