package nl.bioinf.nomi;

import nl.bioinf.nomi.kill_em_all.GameLoop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.Arrays;

@CommandLine.Command(name="VCFfilter", version="VCFfilter 0.1", mixinStandardHelpOptions = true)
public class CommandlineProcessor implements Runnable{
    private static Logger logger = LogManager.getLogger(CommandlineProcessor.class.getName());


    @Parameters(index="0", paramLabel = "<output>", description = "Output VCF file name")
    private String outputVCF;

    // FIXME: should be required, but is ignored
    @Parameters(index="1..*", description = "Input VCF file(s)")
    private String[] inputVCF;

    @Option(names = {"-f", "--filter-value"}, description = "Filter value")
    private String filterOptions;

    @Option(names = {"-v"}, description = "Verbose logging")
    private boolean[] verbose;

    @Override
    public void run() {
        logger.info("Output file: {}", outputVCF);
        logger.info("Input VCF files: {}", Arrays.toString(inputVCF));
        logger.info("Filter options: {}", filterOptions);
        logger.info("Verbosity: {}", Arrays.toString(verbose));

        if (verbose.length > 1) {
            // Set logging to DEBUG
        } else if (verbose.length > 0) {
            // Set logging to INFO
        }

    }
}
