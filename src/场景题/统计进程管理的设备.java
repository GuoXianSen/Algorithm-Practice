package 场景题;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2026/2/3 21:44
 **/

import java.util.*;

public class 统计进程管理的设备 {
    // List中的0、1、2分别代表无线、数通和接入设备
    /**
     * 进程组0
     * process1--->[设备A,设备B]
     * process2--->
     * 进程组1
     * process1--->[设备A,设备B]
     * process2--->
     */
    List<Obj>[] PROCESS_GROUP = new List[3];
    private Integer MAX_MEMORY;
    private final Integer PROCESS_GROUP_LENGTH = 3;

    private Map<Integer, Integer> DEVICE_ID_TO_DEVICE_TYPE_MAP;

    /**
     * 进程组1:,进程组2:[]
     */
    统计进程管理的设备(int procNum, int maxMemSize) {
        DEVICE_ID_TO_DEVICE_TYPE_MAP = new HashMap<>();
        // 每个进程组创建procNum个进程，每个进程的内存上限为maxMemSize。
        MAX_MEMORY = maxMemSize;
        for (Integer i = 0; i < PROCESS_GROUP_LENGTH; i++) {
            PROCESS_GROUP[i] = new ArrayList<>();
            for (int j = 0; j < procNum; j++) {
                PROCESS_GROUP[i].add(new Obj(maxMemSize, j));
            }
        }
        // PROCESS_GROUP_ONE.sort(Comparator.comparingInt(o->o.usedMemory));
        System.out.println(Arrays.toString(PROCESS_GROUP));
    }

    int createDevice(int deviceId, int deviceType, int memSize) {
        int groupIndex = deviceType - 1;
        // Obj obj = PROCESS_GROUP.get(groupIndex);
        // List<DeviceInfo> deviceInfoList = obj.getDeviceInfoList();
        // List<Obj> candidates = new ArrayList<>();
        // for (DeviceInfo deviceInfo : deviceInfoList) {
        //
        // }

        return -1;
    }

    boolean deleteDevice(int deviceId) {
        return false;
    }

    List<DeviceInfo> queryDevice(int deviceType) {

        return new ArrayList<>();
    }


    public static void main(String[] args) {
        统计进程管理的设备 sys = new 统计进程管理的设备(3, 5);
        sys.createDevice(1, 1, 2);
    }
}

class DeviceInfo {
    int deviceId;
    int memSize; // 占用内存大小
    int procId;

    DeviceInfo(int deviceId, int memSize, int procId) {
        this.deviceId = deviceId;
        this.memSize = memSize;
        this.procId = procId;
    }

    public String toString() {
        return String.format(java.util.Locale.ROOT, "[%d, %d, %d]", deviceId, memSize, procId);
    }
}

class Obj {
    private List<DeviceInfo> deviceInfoList; // 设备对象
    private int usedMemory; // 剩余内存
    private int processId;
    private int maxMemorySize;

    public Obj() {
    }

    public int getFreeMemory() {
        return maxMemorySize - usedMemory;
    }

    public boolean canAllocate(int needMemory) {
        return getFreeMemory() >= needMemory;
    }

    public List<DeviceInfo> getDeviceInfoList() {
        return deviceInfoList;
    }

    public void setDeviceInfoList(List<DeviceInfo> deviceInfoList) {
        this.deviceInfoList = deviceInfoList;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setMemoryLeave(int maxMemorySize) {
        this.usedMemory = maxMemorySize;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public Obj(int maxMemorySize, int processId) {
        this.deviceInfoList = new ArrayList<>();
        this.maxMemorySize = maxMemorySize;
        this.processId = processId;
    }

    public Obj(List<DeviceInfo> deviceInfo, int memoryLeave) {
        this.deviceInfoList = deviceInfo;
        this.usedMemory = memoryLeave;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "deviceInfoList=" + deviceInfoList +
                ", usedMemory=" + usedMemory +
                '}';
    }
}