package com.broj;

import com.broj.api.AbstractModel;
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
        Configuration configuration = Configuration.load();
        workingDir = configuration.get("working.dir");
        AbstractModel model = Model.getModel(args[0], args[1], args[2],args[3],args[4], workingDir);
        FileUtil.createDir(workingDir);

        ProcessBuilder compile = ProcessBuilderFactory.getProcessBuilder(model);
        Compiler compiler = new Compiler();
        CompileStatus compileStatus = compiler.compile(compile, model.getParent());
        logger.info("{}", compileStatus);

        ProcessBuilder execution = ProcessBuilderFactory.getExecutionProcessBuilder(model);
        CompileStatus executionStatus = compiler.execute(execution, model);
        logger.info("execution status, {}", executionStatus);
    }
}
