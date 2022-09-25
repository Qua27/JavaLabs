package ru.mirea.lab4;

public class TestComputer {
    enum Computer {
        ASUS(new Processor("Processor1", 6, 3.8, 14), new Memory("Memory1", 3.1, 4), new Monitor("1920x1080", 120, 5)),
        HP(new Processor("Processor2", 8, 4.3, 10), new Memory("Memory1", 3.2, 8), new Monitor("1920x1080", 144, 4)),
        LENOVO(new Processor("Processor3", 4, 3.9, 12), new Memory("Memory1", 2.9, 6), new Monitor("1920x1080", 90, 3));
        private final Processor processor;
        private final Memory memory;
        private final Monitor monitor;

        Computer(Processor processor, Memory memory, Monitor monitor) {
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
        }

        public Processor getProcessor() {
            return processor;
        }

        public Memory getMemory() {
            return memory;
        }

        public Monitor getMonitor() {
            return monitor;
        }
    }
}

class Processor {
    private String name;
    private int numberOfCores;
    private double frequency;
    private int process;

    public Processor(String name, int numberOfCores, double frequency, int process) {
        this.name = name;
        this.numberOfCores = numberOfCores;
        this.frequency = frequency;
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "numberOfCores=" + numberOfCores +
                ", frequency=" + frequency +
                ", process=" + process +
                '}';
    }
}

class Memory {
    private String name;
    private double frequency;
    private int size;

    public Memory(String name, double frequency, int size) {
        this.name = name;
        this.frequency = frequency;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", size=" + size +
                '}';
    }
}

class Monitor {
    private String resolution;
    private double frequency;
    private double responseTime;

    public Monitor(String resolution, double frequency, double responseTime) {
        this.resolution = resolution;
        this.frequency = frequency;
        this.responseTime = responseTime;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "resolution='" + resolution + '\'' +
                ", frequency=" + frequency +
                ", responseTime=" + responseTime +
                '}';
    }
}
