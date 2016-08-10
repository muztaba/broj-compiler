package com.broj;

import com.broj.utils.IOUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static String workingDir;

    public static void main( String[] args ) {
        Model model = Model.getModel(args);
        Configuration configuration = Configuration.load();
        workingDir = configuration.get("working.dir");
        IOUtils.createDir(workingDir);
        ProcessBuilder compile = ProcessBuilderFactory.getProcessBuilder(model.language, model.srcPath, workingDir);
        Compiler compiler = new Compiler();
        CompileStatus compileStatus = compiler.compile(compile, FilenameUtils.getPath(model.srcPath));
        logger.info("{}", compileStatus);
        ProcessBuilder execution = ProcessBuilderFactory.getExecutionProcessBuilder(model.language
                , model.getFileName(false));
        CompileStatus executionStatus = compiler.execute(execution, workingDir, model.inputPath,
                workingDir + "/output.txt", 2000);
    }
}
