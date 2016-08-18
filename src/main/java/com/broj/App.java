package com.broj;

import com.broj.utils.FileUtil;
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
        FileUtil.createDir(workingDir);

        ProcessBuilder compile = ProcessBuilderFactory.getProcessBuilder(model, workingDir);
        Compiler compiler = new Compiler();
        CompileStatus compileStatus = compiler.compile(compile, model.getParent());
        logger.info("{}", compileStatus);

        ProcessBuilder execution = ProcessBuilderFactory.getExecutionProcessBuilder(model);
        CompileStatus executionStatus = compiler.execute(execution, workingDir, model.getInputPath(),
                workingDir + "/output.txt", model.getTimeLimit());
        logger.info("execution status, {}", executionStatus);
    }
}
