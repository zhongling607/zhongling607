package com.yx.util;

import com.yx.model.Menus;

import java.util.ArrayList;
import java.util.List;

//用List构建带有层次结构的json数据
//List父子节点构造树形Json
public class Tree {
    //将list集合转成树形结构的list集合
    public static List<Menus> listToTree(List<Menus> list) {
        //用递归找子。
        List<Menus> treeList = new ArrayList<Menus>();
        for (Menus tree : list) {
            if (tree.getFatherId()==0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    //寻找子节点
    private static Menus findChildren(Menus tree, List<Menus> list) {
        for (Menus node : list) {
            if (node.getFatherId()==(tree.getId())) {
                if (tree.getChild() == null) {
                    tree.setChild(new ArrayList<Menus>());
                }
                tree.getChild().add(findChildren(node, list));
            }
        }
        return tree;
    }

}