# -*- coding: utf-8 -*-


# 败者树来减少多路归并所需的比较次数
BIG_NUM = 987654321
def loser_tree_merge(data):
    # data是个二维数组，其横向向量个数为败者树的路数，每个向量所包含元素为各自路数的元素个数
    paths_nums = len(data)
    length_per_path = [0] * paths_nums
    for i in range(paths_nums):
        length_per_path[i] = len(data[i])

    # 败者树是一棵完全二叉树，归并段输入的数据为树的叶子
    # 完全二叉树节点个数N = N0+N1+N2，其中N0=N2+1，N0 = paths_nums，N1根据根据观察永远为0
    loser_tree_num = paths_nums + (paths_nums - 1) + 1
    loser_tree = [0] * loser_tree_num
    index_per_path = [0] * paths_nums
    offset = loser_tree_num - paths_nums
    # 败者树第一轮还需要另外记录胜者，之后就不用了
    winner = [0] * loser_tree_num
    print(loser_tree)

    # 填充数据到叶子节点
    for i in range(paths_nums):
        loser_tree[offset+i] = [i, data[i][index_per_path[i]]]
        winner[offset+i] = [i, data[i][index_per_path[i]]]
        index_per_path[i] += 1
    print(winner)
    print(loser_tree)

    # 调整非叶子节点，注意是由最后向前调整
    for i in range(offset-1, 0, -1):
        print(i)
        lc = i * 2
        rc = lc + 1
        if winner[lc][1] < winner[rc][1]:
            loser_tree[i] = winner[rc]
            winner[i] = winner[lc]
        else:
            loser_tree[i] = winner[lc]
            winner[i] = winner[rc]
        print(winner)
        print(loser_tree)
    loser_tree[0] = winner[1]
    print(loser_tree)

    while loser_tree[0][1]!=BIG_NUM:
        path,num = loser_tree[0]
        print(num)

        pre_winnner = offset + path

        if index_per_path[path] < length_per_path[path]:
            new_elem = data[path][index_per_path[path]]
            index_per_path[path] += 1
            loser_tree[pre_winnner] = [path, new_elem]
        else:
            new_elem = BIG_NUM
            loser_tree[pre_winnner] = [path,new_elem]

        new_comer = pre_winnner
        loser_tree[0] = loser_tree[new_comer]
        # 对比胜者树，这里每次都只需跟上一级进行比较即可
        while new_comer != 0:
            if loser_tree[new_comer][1] < loser_tree[0][1]:
                loser_tree[new_comer], loser_tree[0] = loser_tree[0], loser_tree[new_comer]
            else:
                pass

            new_comer //= 2
        print(loser_tree)


def main():
    data = [[3,5,8],[1,2,4],[6,7,9]]
    loser_tree_merge(data)


if __name__ == '__main__':
    main()