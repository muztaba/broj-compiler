package com.broj.api;

import com.broj.CompileStatus;
import com.broj.Compiler;
import com.broj.ProcessBuilderFactory;

/**
 * Created by seal on 8/18/16.
 */
public class Task {

    private AbstractModel model;

    public Task(AbstractModel model) {
        this.model = model;
    }

    public CompileStatus compile() {
            ProcessBuilder compile = ProcessBuilderFactory.getProcessBuilder(model);
            Compiler compiler = new Compiler();
            CompileStatus compileStatus = compiler.compile(compile, model.getParent());
            return compileStatus;
    }

    public CompileStatus execute() {
        ProcessBuilder execution = ProcessBuilderFactory.getExecutionProcessBuilder(model);
        Compiler compiler = new Compiler();
        CompileStatus executionStatus = compiler.execute(execution, model);
        return executionStatus;
    }

}
