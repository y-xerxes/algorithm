# -*- coding: utf-8 -*-


# 胜者树来减少多路归并所需的比较次数
BIG_NUM = 100000000
def winner_tree_merge(data):
    # data是个二维数组，其横向向量个数为胜者树的路数，每个向量所包含元素为各自路数的元素个数
    paths_nums = len(data)
    length_per_path = [0] * paths_nums
    for i in range(paths_nums):
        length_per_path[i] = len(data[i])

    # 败者树是一棵完全二叉树，归并段输入的数据为树的叶子
    # 完全二叉树节点个数N = N0+N1+N2，其中N0=N2+1，N0 = paths_nums，N1根据根据观察永远为0
    winner_tree_num = paths_nums + (paths_nums - 1) + 1
    winner_tree = [0] * winner_tree_num
    paths_index = [0] * paths_nums
    offset = winner_tree_num - paths_nums

    # 填充数据到叶子节点
    for i in range(paths_nums):
        winner_tree[offset+i] = [i,data[i][paths_index[i]]]
        paths_index[i] += 1
    print(winner_tree)

    # 调整非叶子节点，注意是由最后向前调整
    for i in range(offset-1, 0, -1):
        lc = i * 2
        rc = lc + 1
        if winner_tree[lc][1] < winner_tree[rc][1]:
            winner_tree[i] = winner_tree[lc]
        else:
            winner_tree[i] = winner_tree[rc]
    print(winner_tree)

    while winner_tree[1][1] != BIG_NUM:
        # 取出一个元素
        path, num = winner_tree[1]
        print(num)

        # 在取出元素所在的路取出一个新元素，加入之前取出元素的位置
        if paths_index[path] < length_per_path[path]:
            new_elem = data[path][paths_index[path]]
            paths_index[path] += 1
            winner_tree[offset+path] = [path, new_elem]
        else:
            # 如果取出元素的一路空了，就不加入新元素了
            new_elem = BIG_NUM
            winner_tree[offset+path] = [path, new_elem]

        father = (offset + path) // 2
        while father != 0:
            lc = father * 2
            rc = lc + 1
            if winner_tree[lc][1] < winner_tree[rc][1]:
                winner_tree[father] = winner_tree[lc]
            else:
                winner_tree[father] = winner_tree[rc]

            father //= 2

        print(winner_tree)


def main():
    data = [[1,2],[3,5,8],[6,7,9]]
    winner_tree_merge(data)
    

if __name__ == '__main__':
    main()
