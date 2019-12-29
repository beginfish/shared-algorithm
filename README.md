# shared-algorithm
Algorithm learning and finishing

TOC
=================
* [1.1 对于10亿个数据如何从中取出排名前30的热点数据](#对于10亿个数据如何从中取出排名前30的热点数据)
* [1.2 一个包含10亿人年龄的数据,将各个年龄的人数由小到大依次输出](#一个包含10亿人年龄的数据,将各个年龄的人数由小到大依次输出)
* [1.3 给定一个包含1亿数据的邮箱垃圾黑名单,如何快速过滤垃圾邮箱](#给定一个包含1亿数据的邮箱垃圾黑名单,如何快速过滤垃圾邮箱)



解决方案
=================
## 对于10亿个数据如何从中取出排名前30的热点数据 
- 问题分类
  1. TOP K 类问题
- 解决方案
  1. 使用堆树解决。根据场景选择最大堆，或者最小堆。

## 一个包含10亿人年龄的数据,将各个年龄的人数由小到大依次输出
- 问题分类
  1. 灵活使用数组类
- 解决方案
  1. 定义一个200大小的数组。使数组小标表示年龄，下标对应元素表示人数

## 给定一个包含1亿数据的邮箱垃圾黑名单,如何快速过滤垃圾邮箱
- 问题分类
  1. 布隆过滤器
- 解决方案
  1. 使用布隆过滤垃圾邮箱,对于误差数据可以使用白名单处理