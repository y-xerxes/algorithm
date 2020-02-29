# Merkle哈希树（Merkle Hash Tree）
最初用于高效Lamport签名认证，后来被广泛应用在分布式领域，主要用来在海量数据下快速定位少量变化的数据内容（变化原因可能是损毁、篡改或者正常变化等）。
## 原理
![](/Users/xerxes/Development/algorithm/resources/Merkle%E6%A0%91.jpg)
子节点是每个数据项或者一批数据项对应的hash值，中间节点保存对其所有子节点hash值再次进行hash运算后的值，依次由下往上类推，直到根节点。根节点保存的Top Hash代表整棵树的hash值。
Merkle常用于快速侦测部分数据正常或者异常的变动。当某个底层数据发生变化，其对应Merkle树的子节点hash值会跟着变化，子节点的父节点hash值也随之变化，直到根节点。通过Merkle树，可以在O(log(n))时间内快速定位变化的数据内容。
