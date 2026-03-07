package 二叉树;

import java.util.*;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/11/12 22:10
 **/
public class TreeTest {
    /**
     * {id: {1,2,3,4,5}}
     */
    public static Map<Integer, Set<Integer>> CHILD_MAP = new HashMap<>();
    public static Map<Integer, Integer> PARENT_MAP = new HashMap<>();
    public static Map<Integer, Node> NODE_MAP = new HashMap<>();

    TreeTest() {
        NODE_MAP.put(0, new Node(0, 0, 0));
    }

    // 创建节点
    public boolean createNode(int id, int parentId, int type) {
        if (!NODE_MAP.containsKey(parentId) || !NODE_MAP.containsKey(id)) {
            return false;
        }
        Node node = new Node(id, parentId, type);
        Node parent = NODE_MAP.get(parentId);
        parent.children.add(node);

        return true;
    }

    // 设置角色权限
    public void setUserPermission(String user, int nodeId, int role) {

    }

    // 输出所有代码仓
    public List<Node> getAllReposUnder(int nodeId) {
        Node node = NODE_MAP.get(nodeId);
        if (node == null) throw new IllegalArgumentException("节点不存在: " + nodeId);
        List<Node> result = new ArrayList<>();
        collectRepos(node, result);
        return result;
    }

    public void collectRepos(Node node, List<Node> result) {
        if (node.type == 1) result.add(node);
        for (Node child : node.children) {
            collectRepos(child, result);
        }
    }

    // 打印树结构
    // public void printTree() {
    //     printNode(0, "");
    // }

    private void printNode(Node node, String prefix) {
        System.out.println(prefix + node);
        for (Node child : node.children) {
            printNode(child, prefix + "  ");
        }
    }

    public static void main(String[] args) {
        TreeTest manager = new TreeTest();

        // === 1. 创建组织与仓库结构 ===
        manager.createNode(1, 0, 0); // 组织1
        manager.createNode(2, 0, 0); // 组织2`
        manager.createNode(3, 1, 1); // 仓库3
        manager.createNode(4, 1, 1); // 仓库4
        manager.createNode(5, 2, 0); // 子组织5
        manager.createNode(6, 5, 1); // 仓库6

        List<Node> repos = manager.getAllReposUnder(1);
        repos.forEach(System.out::println);
    }
}

class Node {
    int id; // 组织id
    int parentId; // 父节点id
    int type; // 节点类型 0为组织，1为代码仓
    List<Node> children = new ArrayList<>();
    Map<Integer, Integer> userRoles = new HashMap<>();

    public Node() {
    }

    public Node(int id, int parentId, int type) {
        this.id = id;
        this.parentId = parentId;
        this.type = type;
    }

    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * 设置
     *
     * @param parentId
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * 设置
     *
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取
     *
     * @return children
     */
    public List<Node> getChildren() {
        return children;
    }

    /**
     * 设置
     *
     * @param children
     */
    public void setChildren(List<Node> children) {
        this.children = children;
    }

    /**
     * 获取
     *
     * @return userRoles
     */
    public Map<Integer, Integer> getUserRoles() {
        return userRoles;
    }

    /**
     * 设置
     *
     * @param userRoles
     */
    public void setUserRoles(Map<Integer, Integer> userRoles) {
        this.userRoles = userRoles;
    }

    public String toString() {
        return "Node{id = " + id + ", parentId = " + parentId + ", type = " + type + ", children = " + children + ", userRoles = " + userRoles + "}";
    }
}
