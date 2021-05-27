## RabbitMQ

### 1.什么是中间件？

#### 1.简介

![image-20210518221246125](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210518221246125.png)

我国企业从20世纪80年代开始就逐渐进行信息化建设，由于方法和体系的不成熟，以及企业业务和市场需求的不断变化，一个企业可能同时运行着多个不同的业务系统，这些系统可能基于不同的操作系统、不同的数据库、异构的网络环境。现在的问题是，如何把这些信息系统结合成一个有机地协同工作的整体，真正实现企业跨平台、分布式应用。中间件便是解决之道，它用自己的复杂换取了企业应用的简单。

**中间件（Middleware）**：是处于操作系统和应用程序之间的软件，也有人认为它应该属于操作系统中的一部分。人们在使用中间件时，往往是一组中间件集成在一起，构成一个平台（包括开发平台和运行平台），但在这组中间件中必须要有一个通信中间件，即中间件=平台+通信，这个定义也限定了只有用于分布式系统中才能称为中间件，同时还可以把它与支撑软件和实用软件区分开来。

#### 2.举例

- RMI（Remote Method Invocations, 远程调用）
- Load Balancing(负载均衡，将访问负荷分散到各个服务器中)
- Transparent Fail-over(透明的故障切换)
- Clustering(集群,用多个小的服务器代替大型机）
- Back-end-Integration(后端集成，用现有的、新开发的系统如何去集成遗留的系统)
- Transaction事务（全局/局部）全局事务（分布式事务）局部事务（在同一数据库联接内的事务）
- Dynamic Redeployment(动态重新部署,在不停止原系统的情况下，部署新的系统）
- System Management(系统管理)
- Threading(多线程处理)
- Message-oriented Middleware面向消息的中间件（异步的调用编程）
- Component Life Cycle(组件的生命周期管理)
- Resource pooling（资源池）
- Security（安全）
- Caching（缓存）

**满足中间件特性的都可以称作中间件**，例如:rabbitMQ,Nginx,MySQL,Redis

### 2.为什么要使用中间件

具体地说，中间件屏蔽了底层操作系统的复杂性，使程序开发人员面对一个简单而统一的开发环境，减少程序设计的复杂性，将注意力集中在自己的业务上，不必再为程序在不同系统软件上的移植而重复工作，从而大大减少了技术上的负担。中间件带给应用系统的，不只是开发的简便、开发周期的缩短，也减少了系统的维护、运行和管理的工作量，还减少了计算机总体费用的投入。

### 3.中间件技术的特点

为解决分布异构问题，人们提出了中间件(middleware)的概念。中间件是位于平台(硬件和操作系统)和应用之间的通用服务，如下图所示，这些服务具有标准的程序接口和协议。针对不同的操作系统和硬件平台，它们可以有符合接口和协议规范的多种实现。

![img](https://img-blog.csdnimg.cn/2018111321555179.jpg)

也许很难给中间件一个严格的定义，但中间件应具有如下的一些特点：

- 满足大量应用的需要
- 运行于多种硬件和OS平台
- 支持分布计算，提供跨网络、硬件和OS平台的透明性的应用或服务的交互
- 支持标准的协议
- 支持标准的接口

由于标准接口对于可移植性和标准协议对于互操作性的重要性，中间件已成为许多标准化工作的主要部分。对于应用软件开发，中间件远比操作系统和网络服务更为重要，中间件提供的程序接口定义了一个相对稳定的高层应用环境，不管底层的计算机硬件和系统软件怎样更新换代，只要将中间件升级更新，并保持中间件对外的接口定义不变，应用软件几乎不需任何修改，从而保护了企业在应用软件开发和维护中的重大投资。

简单说：中间件有个很大的特点，是脱离于具体设计目标，而具备提供普遍独立功能需求的模块。这使得中间件一定是可替换的。如果一个系统设计中，中间件是不可替换的，不是架构、框架设计有问题，那么就是这个中间件，在 别处可能是个中间件，在这个系统内是引擎。

### 4.在项目中什么时候使用中间件技术

在项目的架构和重构中，使用任何技术和架构的改变我们都需要谨慎斟酌和思考，因为任何技术的融入和变化都可能人员，技术，和成本的增加，中间件的技术一般在一些互联网公司或者项目中使用比较多，如果你仅仅还只是一个初创公司建议还是使用单体架构，最多加个缓存中间件即可，不要盲目追求新或者所谓的高性能，而追求的背后一定是业务的驱动和项目的驱动，因为一旦追求就意味着你的学习成本，公司的人员结构以及服务器成本，维护和运维的成本都会增加，所以需要谨慎选择和考虑。

但是作为一个开放人员，一定要有学习中间件技术的能力和思维，否则很容易当项目发展到一个阶段在去掌握估计或者在面试中提及，就会给自己带来不小的困扰，在当今这个时代这些技术也并不是什么新鲜的东西，如果去掌握和挖掘最关键的还是自己花时间和花精力去探讨和研究。

### 5.中间件技术及架构概述

![img](https://img-blog.csdnimg.cn/img_convert/5d65bd92f6618e21df29f41b6cdd5312.png)

学习技巧：

- 理解中间件在项目架构中的作用，以及各中间件的底层实现。
- 可以使用一些类比的生活概念去理解中间件，
- 使用一些流程图或者脑图的方式去梳理各个中间件在架构中的作用
- 尝试用java技术去实现中间件的远离
- 静下来去思考中间件在项目中设计的和使用的原因
- 如果找到对应的替代总结方案
- 尝试编写博文总结类同中间件技术的对比和使用场景。
- 学会查看中间件的源码以及开开源项目和博文。

学习目标：

- 什么是消息中间件
- 什么是协议
- 什么是持久化
- 消息分发
- 消息的高可用
- 消息的集群
- 消息的容错
- 消息的冗余

### 6.什么是消息中间件

在实际的项目中，大部分的企业项目开发中，在早期都采用的是单体的架构模式，如下图：

![img](https://img-blog.csdnimg.cn/img_convert/968221c530146abaaa8eb947680a8c8e.png)

### 7.单体架构

在企业开发的中，大部分的初期架构都采用的是单体架构的模式进行架构，而这种架构的典型的特点：就是把所有的业务和模块，源代码，静态资源文件等都放在一个一工程中，如果其中的一个模块升级或者迭代发生一个很小变动都会重新编译和重新部署项目。 这种的架构存在的问题就是：
1：耦合度太高
2：运维的成本过高
3：不易维护
4：服务器的成本高
5：以及升级架构的复杂度也会增大
这样就有后续的分布式架构系统。如下

### 8.分布式架构

![img](https://img-blog.csdnimg.cn/img_convert/77b1e5c02365561c476ca8f9b4e7beaa.png)

何谓分布式系统呢：**通俗一点，就是一个请求由服务器端的多个服务（服务或者系统）协同处理完成**

和单体架构不同的是，单体架构是一个请求发起jvm调度线程（确切的是tomcat线程池）分配线程Thread来处理请求直到释放，

而分布式是系统是：一个请求是由多个系统共同来协同完成，jvm和环境都可能是独立。如果生活中的比喻的话，单体架构就想建设一个小房子很快就能够搞定，如果你要建设一个鸟巢或者大型的建筑，你就必须是各个环节的协同和分布，这样目的也是项目发展都后期的时候要去部署和思考的问题。我们也不能看出来：分布式架构系统存在的特点和问题如下：

**存在问题**
1：学习成本高，技术栈过多
2：运维成本和服务器成本增高
3：人员的成本也会增高
4：项目的负载度也会上升
5：面临的错误和容错性也会成倍增加
6：占用的服务器端口和通讯的选择的成本高
7：安全性的考虑和因素逼迫可能选择RMI/MQ相关的服务器端通讯。

**好处**
1：服务系统的独立，占用的服务器资源减少和占用的硬件成本减少，
确切的说是：可以合理的分配服务资源，不造成服务器资源的浪费
2：系统的独立维护和部署，耦合度降低，可插拔性。
3：系统的架构和技术栈的选择可以变的灵活（而不是单纯的选择java）
4：弹性的部署，不会造成平台因部署造成的瘫痪和停服的状态。

### 9.基于消息中间件的分布式系统架构

![img](https://img-blog.csdnimg.cn/img_convert/b3c637c211bcc7dbc09235060967391a.png)

从上图中可以看出来，消息中间件的是
1：利用可靠的消息传递机制进行系统和系统直接的通讯
2：通过提供消息传递和消息的排队机制，它可以在分布式系统环境下扩展进程间的通讯。

### 10.消息中间件的应用场景

1:跨系统数据传递
2:高并发的流量削峰(将某些串行操作，改为并行操作)
3:数据的分发和异步处理
4:大数据分析与传递
5:分布式事务
比如你有一个数据要进行迁移或者请求并发过多的时候，比如你有10W的并发请求下订单，我们可以在这些订单入库之前，我们可以把订单请求堆积到消息队列中，让它稳健可靠的入库和执行。

### 11.常见的消息中间件

ActiveMQ、RabbitMQ、Kafka、RocketMQ等.

### 12.消息中间件的本质及设计

它是一种接受数据，接受请求、存储数据、发送数据等功能的技术服务。

MQ消息队列：负责数据的传接受，存储和传递，所以性能要过于普通服务和技术

![img](https://img-blog.csdnimg.cn/img_convert/78243aee6eeb1b15385a1105408daad6.png)

谁来生产消息，存储消息和消费消息呢？

![img](https://img-blog.csdnimg.cn/img_convert/65dddac57b0f759d2ba8f4294322e477.png)

### 13.消息中间件的核心组成部分

1：消息的协议
2：消息的持久化机制
3：消息的分发策略
4：消息的高可用，高可靠
5：消息的容错机制

### 14.消息队列协议

#### 1.什么是协议

![img](https://img-blog.csdnimg.cn/img_convert/2dff76fa89e00c13b0e47692d931e324.png)

我们知道消息中间件负责数据的传递，存储，和分发消费三个部分，数据的存储和分发的过程中肯定要遵循某种约定成俗的规范，你是采用底层的TCP/IP，UDP协议还是其他的自己取构建等，而这些约定成俗的规范就称之为：协议。

所谓协议是指：
1：计算机底层操作系统和应用程序通讯时共同遵守的一组约定，只有遵循共同的约定和规范，系统和底层操作系统之间才能相互交流。
2：和一般的网络应用程序的不同，它主要负责数据的接受和传递，所以性能比较的高。
3：协议对数据格式和计算机之间交换数据都必须严格遵守规范。

RabbitMQ使用的是AMQP协议，是在TCP/IP协议层上又进行了一层封装

#### 2.网络协议三要素

1.语法。语法是用户数据与控制信息的结构与格式,以及数据出现的顺序。
2.语义。语义是解释控制信息每个部分的意义。它规定了需要发出何种控制信息,以及完成的动作与做出什么样的响应。
3.时序。时序是对事件发生顺序的详细说明。

比如我MQ发送一个信息，是以什么数据格式发送到队列中，然后每个部分的含义是什么，发送完毕以后的执行的动作，以及消费者消费消息的动作，消费完毕的响应结果和反馈是什么，然后按照对应的执行顺序进行处理。如果你还是不理解：大家每天都在接触的http请求协议:

1：语法：http规定了请求报文和响应报文的格式。

2：语义：客户端主动发起请求称之为请求。（这是一种定义，同时你发起的是post/get请求

3：时序：一个请求对应一个响应。（一定先有请求在有响应，这个是时序）

而消息中间件采用的并不是http协议，而常见的消息中间件协议有：OpenWire、AMQP、MQTT、Kafka，OpenMessage协议。

**为什么消息中间件不直接使用http协议呢？**

1: 因为http请求报文头和响应报文头是比较复杂的，包含了cookie，数据的加密解密，状态码，响应码等附加的功能，但是对于一个消息而言，我们并不需要这么复杂，也没有这个必要性，它其实就是负责数据传递，存储，分发就行，一定要追求的是高性能。尽量简洁，快速。

2:大部分情况下http大部分都是短链接，在实际的交互过程中，一个请求到响应很有可能会中断，中断以后就不会就行持久化，就会造成请求的丢失。这样就不利于消息中间件的业务场景，因为消息中间件可能是一个长期的获取消息的过程，出现问题和故障要对数据或消息就行持久化等，目的是为了保证消息和数据的高可靠和稳健的运行。

#### 3.AMQP协议

AMQP：(全称：Advanced Message Queuing Protocol) 是高级消息队列协议。由摩根大通集团联合其他公司共同设计。是一个提供统一消息服务的应用层标准高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计。基于此协议的客户端与消息中间件可传递消息，并不受客户端/中间件不同产品，不同的开发语言等条件的限制。Erlang中的实现有RabbitMQ等。
特性：
1：分布式事务支持。
2：消息的持久化支持。
3：高性能和高可靠的消息处理优势。

AMQP协议的支持者：

![img](https://img-blog.csdnimg.cn/img_convert/d12a7781d55fdfc49d125fdaa53a0dc0.png)

#### 4.MQTT协议

MQTT协议：（Message Queueing Telemetry Transport）消息队列是IBM开放的一个即时通讯协议，物联网系统架构中的重要组成部分。
特点：
1：轻量
2：结构简单
3：传输快，不支持事务
4：没有持久化设计。
应用场景：
1：适用于计算能力有限
2：低带宽
3：网络不稳定的场景。
支持者：

![img](https://img-blog.csdnimg.cn/img_convert/d12a7781d55fdfc49d125fdaa53a0dc0.png)

#### 5.OpenMessage协议

是近几年由阿里、雅虎和滴滴出行、Stremalio等公司共同参与创立的分布式消息中间件、流处理等领域的应用开发标准。
特点：
1：结构简单
2：解析速度快
3：支持事务和持久化设计。

![img](https://img-blog.csdnimg.cn/img_convert/6324dab30c911883871c8b9511527a1c.png)

#### 6.Kafka协议

Kafka协议是基于TCP/IP的二进制协议。消息内部是通过长度来分割，由一些基本数据类型组成。
特点是：
1：结构简单
2：解析速度快
3：无事务支持，不太适合分布式事务场景
4：有持久化设计

![img](https://img-blog.csdnimg.cn/img_convert/de7fec9405ccbf6f749b827d7f24e51a.png)

#### 7.小结

协议：是在tcp/ip协议基础之上构建的一种约定成俗的规范和机制、它的主要目的是可以让客户端（应用程序Java，go）进行沟通和通信。并且在这种写一下规范必须具有持久性、高可用、高可靠的性能

### 15.消息队列的持久化

#### 1.持久化

简单来说就是将数据存入磁盘，而不是存在内存中随服务器重启断开而消失，使数据能够永久保存。

![img](https://img-blog.csdnimg.cn/img_convert/5cc256b388eeb5663ff34c0c3ad3b7d7.png)

#### 2.常见的持久化方式

|          | **ActiveMQ** | **RabbitMQ** | **Kafka** | **RocketMQ** |      |
| -------- | ------------ | ------------ | --------- | :----------- | ---- |
| 文件存储 | 支持         | 支持         | 支持      | 支持         |      |
| 数据库   | 支持         | /            | /         | /            |      |

### 16.消息的分发策略

#### 1.消息的分发策略

MQ消息队列有如下几个角色
1：生产者
2：存储消息
3：消费者
那么生产者生成消息以后，MQ进行存储，消费者是如何获取消息的呢？一般获取数据的方式无外乎推（push）或者拉（pull）两种方式，典型的git就有推拉机制，我们发送的http请求就是一种典型的拉取数据库数据返回的过程。而消息队列MQ是一种推送的过程，而这些推机制会适用到很多的业务场景也有很多对应推机制策略。

#### 2.场景分析一

![img](https://img-blog.csdnimg.cn/img_convert/d1d29a3244ad35128c8ef2ea17642d00.png)

比如我在APP上下了一个订单，我们的系统和服务很多，我们如何得知这个消息被哪个系统或者哪些服务或者系统进行消费，那这个时候就需要一个分发的策略。这就需要消费策略。或者称之为消费的方法论。

#### 3.场景分析二

![img](https://img-blog.csdnimg.cn/img_convert/c50bfcfefbbfd98fec28bd19c10a5421.png)

在发送消息的过程中可能会出现异常，或者网络的抖动，故障等等因为造成消息的无法消费，比如用户在下订单，消费MQ接受，订单系统出现故障，导致用户支付失败，那么这个时候就需要消息中间件就必须支持消息重试机制策略。也就是支持：出现问题和故障的情况下，消息不丢失还可以进行重发。

#### 4.消息分发策略和机制对比

|          | ActiveMQ | RabbitMQ | Kafka | RocketMQ |
| -------- | -------- | -------- | ----- | -------- |
| 发布订阅 | 支持     | 支持     | 支持  | 支持     |
| 轮询分发 | 支持     | 支持     | 支持  | /        |
| 公平分发 | /        | 支持     | 支持  | /        |
| 重发     | 支持     | 支持     | /     | 支持     |
| 消息拉取 | /        | 支持     | 支持  | 支持     |

发布订阅：只要有人订阅了，那么生产者生产了多少条，交给MQ之后，MQ会给每一个消费者推送相应的条数

![image-20210519105232454](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210519105232454.png)

轮询分发：生产者发布消息给MQ，MQ不论服务器性能怎么样，都会公平的以轮询的机制，将所有发布的消息，均匀的平均分配，发布给每个消费者。

![image-20210519105410940](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210519105410940.png)

公平分发：会造成数据的倾斜。会根据消费者服务器的性能，以一定的比例发布给消费者

![image-20210519105451636](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210519105451636.png)

重发：MQ发送给消费方之后，消费方接受失败，没有发送回来应答请求，那么MQ会将消息**重新投递到提供相同服务的正常的消费方。**

### 17.消息队列高可用和高可靠

#### 1.什么是高可用机制

所谓高可用：是指产品在规定的条件和规定的时刻或时间内处于可执行规定功能状态的能力。
当业务量增加时，请求也过大，一台消息中间件服务器的会触及硬件（CPU,内存，磁盘）的极限，一台消息服务器你已经无法满足业务的需求，所以消息中间件必须支持集群部署。来达到高可用的目的。

#### 2.集群模式1 - Master-slave主从共享数据的部署方式

![img](https://img-blog.csdnimg.cn/img_convert/6d5a68de3f8de6149b3cafd4a28c4091.png)

解说：生产者讲消费发送到Master节点，所有的都连接这个消息队列共享这块数据区域，Master节点负责写入，一旦Master挂掉，slave节点继续服务。从而形成高可用。一般应用于小规模应用

#### 3.集群模式2 - Master- slave主从同步部署方式

![img](https://img-blog.csdnimg.cn/img_convert/39d3615a1a9a126796e77acfa0529585.png)

解释：这种模式写入消息同样在Master主节点上，但是主节点会同步数据到slave节点形成副本，和zookeeper或者redis主从机制很类同。这样可以达到负载均衡的效果，如果消费者有多个这样就可以去不同的节点就行消费，因为消息的拷贝和同步会占用很大的带宽和网络资源。在后续的rabbtmq中会有使用。

#### 4.集群模式3 - 多主集群同步部署模式

![img](https://img-blog.csdnimg.cn/img_convert/92ceac29ec49c309f052b657dda03e70.png)解释：和上面的区别不是特别的大，但是它的写入可以往任意节点去写入。

#### 5.集群模式4 - 多主集群转发部署模式

![img](https://img-blog.csdnimg.cn/img_convert/c1d84bf25a281e020662493d707ebfbf.png)

解释：如果你插入的数据是broker-1中，元数据信息会存储数据的相关描述和记录存放的位置（队列）。
它会对描述信息也就是元数据信息就行同步，如果消费者在broker-2中进行消费，发现自己几点没有对应的消息，可以从对应的元数据信息中去查询，然后返回对应的消息信息，场景：比如买火车票或者黄牛买演唱会门票，比如第一个黄牛有顾客说要买的演唱会门票，但是没有但是他会去联系其他的黄牛询问，如果有就返回。

#### 6.集群模式5 Master-slave与Breoker-cluster组合的方案

![img](https://img-blog.csdnimg.cn/img_convert/531282de817bf980b9064de942e5dd96.png)

解释：实现多主多从的热备机制来完成消息的高可用以及数据的热备机制，在生产规模达到一定的阶段的时候，这种使用的频率比较高。

这么集群模式，具体在后续的课程中会进行一个分析和讲解。他们的最终目的都是为保证：消息服务器不会挂掉，出现了故障依然可以抱着消息服务继续使用。

反正终归三句话：
1：要么消息共享，
2：要么消息同步
3：要么元数据共享

#### 7.什么是高可靠机制

所谓高可用是指：是指系统可以无故障低持续运行，比如一个系统突然崩溃，报错，异常等等并不影响线上业务的正常运行，出错的几率极低，就称之为：高可靠。
在高并发的业务场景中，如果不能保证系统的高可靠，那造成的隐患和损失是非常严重的。
如何保证中间件消息的可靠性呢？可以从两个方面考虑：
1：消息的传输：通过协议来保证系统间数据解析的正确性。
2：消息的存储可靠：通过持久化来保证消息的可靠性。

### RabbitMQ入门及安装

#### 1.概述

RabbitMQ是一个开源的遵循AMQP协议实现的基于Erlang语言编写，支持多种客户端（语言）。用于在分布式系统中存储消息，转发消息，具有高可用，高可扩性，易用性等特征。

#### 2.安装RabbitMQ

我的是Ubuntu18

按照这个博客安装即可

https://blog.csdn.net/u013310037/article/details/107092142/?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242

#### 3.浏览器访问

http://ip:15672/ 如下：

http://192.168.45.135:15672/#/

#### 4.授权账号和密码

创建用户 输入用户名和密码

```bash
rabbitmqctl add_user admin admin
```

设置用户分配操作权限

```bash
rabbitmqctl set_user_tags admin administrator
```

用户级别：

- administrator 可以登录控制台、查看所有信息、可以对rabbitmq进行管理
- monitoring 监控者 登录控制台，查看所有信息
- policymaker 策略制定者 登录控制台,指定策略
- managment 普通管理员 登录控制台

为用户添加资源权限

```bash
rabbitmqctl.bat set_permissions -p / admin ".*" ".*" ".*"
```

### RabbitMQ的角色分类

#### 1.none

- 不能访问management plugin

#### 2.management：查看自己相关节点信息

- 列出自己可以通过AMQP登入的虚拟机
- 查看自己的虚拟机节点 virtual hosts的queues,exchanges和bindings信息
- 查看和关闭自己的channels和connections
- 查看有关自己的虚拟机节点virtual hosts的统计信息。包括其他用户在这个节点virtual hosts中的活动信息。

#### 3.Policymaker

- 包含management所有权限
- 查看和创建和删除自己的virtual hosts所属的policies和parameters信息。

#### 4.Monitoring

- 包含management所有权限
- 罗列出所有的virtual hosts，包括不能登录的virtual hosts。
- 查看其他用户的connections和channels信息
- 查看节点级别的数据如clustering和memory使用情况
- 查看所有的virtual hosts的全局统计信息。

#### 5.Administrator

- 最高权限
- 可以创建和删除virtual hosts
- 可以查看，创建和删除users
- 查看创建permisssions
- 关闭所有用户的connections

### RabbitMQ入门案例 - Simple 简单模式

![img](https://www.rabbitmq.com/img/tutorials/python-one.png)

#### 01、实现步骤

1：jdk1.8
2：构建一个maven工程
3：导入rabbitmq的maven依赖
4：启动rabbitmq-server服务
5：定义生产者
6：定义消费者
7：观察消息的在rabbitmq-server服务中的过程

#### 02、构建一个maven工程

![image-20210521102622319](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210521102622319.png)

#### 03、导入rabbitmq的maven依赖

##### 03-1：Java原生依赖

```xml
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.10.0</version>
</dependency>
```

##### 03-2：spring依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.amqp/spring-amqp -->
<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-amqp</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.amqp/spring-rabbit -->
<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-rabbit</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>
```

##### 03-3、springboot依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
    <version>2.3.0.RELEASE</version>
</dependency>
```

#### 04、启动rabbitmq-server服务

#### 05、定义生产者

```java
package com.echo.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Producer {
    public static void main(String[] args) {
        //所有的中间价技术都是基于tcp/ip协议的，并在此协议上构建的。rabbitmq遵循的是amqp协议。
        //所以既然如此，必然会有ip和port
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.声明队列
            String queueName = "queue1";
            //声明队列时的五个参数
            /**
             * @params1:队列名称
             * @params2:是否要持久化 durable=false,所谓持久化消息就是 是否会存盘，
             * false：非持久化，true:持久化，非持久化会存盘吗？
             * @params3:排他性，是否是一个独占队列
             * @params4:最后一个消费者消费完消息之后，是否自动把队列删除
             * @params5:携带一些附加的参数
             */
            channel.queueDeclare(queueName,false,false,false,null);
            //5.准备消息内容
            String message = "Hello world";
            //6.发送消息给队列
            channel.basicPublish("",queueName,null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("消息发送成功");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```

1：执行发送，这个时候可以在web控制台查看到这个队列queue的信息

![img](https://img-blog.csdnimg.cn/img_convert/239193770bbf2827f152e70cf2e2f25a.png)

![img](https://img-blog.csdnimg.cn/img_convert/f9d2640dc17ed042016a9163cc578c2f.png)



2：我们可以进行对队列的消息进行预览和测试如下：

#### 06、定义消费者

```java
package com.echo.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Consumer {
    public static void main(String[] args) {
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();

            channel.basicConsume("queue1", true, new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("收到的消息是" + new String(message.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String consumeTag) throws IOException {
                    System.out.println("接受消息失败...");
                }
            });
            System.out.println("开始接收消息");
            //在这里暂停一下，相当于getchar()
            System.in.read();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```

1.执行结果

![image-20210521113720057](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210521113720057.png)

![image-20210521113752780](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210521113752780.png)

2.重启服务之后

![image-20210521114037867](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210521114037867.png)

队列没有了。

**持久化队列和非持久化队列的区别**

持久化队列：在rabbitMQ服务重启后，该队列也会存在,队列中的消息也会存在

非持久化队列：队列只存在于rabbitMQ的运行过程中，在rabbitMQ服务重启后，队列不会存在，队列中的消息在rabbitMQ的运行过程中会持久化，但是在rabbitMQ服务重启后，持久化的消息也会消失。

### AMQP协议

#### 1.简介

AMQP全称：Advanced Message Queuing Protocol(高级消息队列协议)。是应用层协议的一个开发标准，为面向消息的中间件设计。

#### 2.AMQP生产者流转过程

![img](https://img-blog.csdnimg.cn/img_convert/be902d1a8713e221d1f93e2f6fae936c.png)

可以看出来啊，每次连接的建立都需要3次握手和4次挥手

#### 3.AMQP消费者流转过程

![img](https://img-blog.csdnimg.cn/img_convert/760304fced101daf71919620f93d51cb.png)

#### 4.为什么RabbitMQ是基于channel而不是连接的操作

我们知道无论是生产者还是消费者，都需要和 RabbitMQ Broker 建立连接，这个连接就是一条 TCP 连接，也就是 Connection。

一旦 TCP 连接建立起来，客户端紧接着可以创建一个 AMQP 信道（Channel），每个信道都会被指派一个唯一的 ID。

信道是建立在 Connection 之上的虚拟连接，RabbitMQ 处理的每条 AMQP 指令都是通过信道完成的。

![img](https://img2018.cnblogs.com/blog/696188/201901/696188-20190127151121052-1828578725.png)

我们完全可以使用 Connection 就能完成信道的工作，为什么还要引入信道呢？

试想这样一个场景，一个应用程序中有很多个线程需要从 RabbitMQ 中消费消息，或者生产消息，那么必然需要建立很多个 Connection，也就是多个 TCP 连接。

然而对于操作系统而言，建立和销毁 TCP 连接是非常昂贵的开销，如果遇到使用高峰，性能瓶颈也随之显现。

RabbitMQ 采用类似 NIO（Non-blocking I/O）的做法，选择 TCP 连接复用，不仅可以减少性能开销，同时也便于管理。

 

每个线程把持一个信道，所以信道复用了 Connection 的 TCP 连接。同时 RabbitMQ 可以确保每个线程的私密性，就像拥有独立的连接一样。当每个信道的流量不是很大时，复用单一的 Connection 可以在产生性能瓶颈的情况下有效地节省 TCP 连接资源。但是信道本身的流量很大时，这时候多个信道复用一个 Connection 就会产生性能瓶颈，进而使整体的流量被限制了。此时就需要开辟多个 Connection，将这些信道均摊到这些 Connection 中，至于这些相关的调优策略需要根据业务自身的实际情况进行调节。

 

信道在 AMQP 中是一个很重要的概念，大多数操作都是在信道这个层面展开的。

比如 channel.exchangeDeclare、channel.queueDeclare、channel.basicPublish、channel.basicConsume 等方法。

RabbitMQ 相关的 API 与 AMQP 紧密相连，比如 channel.basicPublish 对应 AMQP 的 Basic.Publish 命令。

### RabbitMQ中的核心组成部分

#### 1.RabbitMQ中的核心组成部分

![image-20210522093841959](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522093841959.png)

核心概念：
**Server**：又称Broker ,接受客户端的连接，实现AMQP实体服务。 安装rabbitmq-server
**Connection**：连接，应用程序与Broker的网络连接 TCP/IP/ 三次握手和四次挥手
**Channel**：网络信道，几乎所有的操作都在Channel中进行，Channel是进行消息读写的通道，客户端可以建立对各Channel，每个Channel代表一个会话任务。
**Message** :消息：服务与应用程序之间传送的数据，由Properties和body组成，Properties可是对消息进行修饰，比如消息的优先级，延迟等高级特性，Body则就是消息体的内容。
**Virtual Host** 虚拟地址，用于进行逻辑隔离，最上层的消息路由，一个虚拟主机理由可以有若干个Exchange和Queue，同一个虚拟主机里面不能有相同名字的Exchange
**Exchange**：交换机，接受消息，根据路由键发送消息到绑定的队列。(不具备消息存储的能力)
**Bindings**：Exchange和Queue之间的虚拟连接，binding中可以保护多个routing key.交换机和队列之间的绑定。
**Routing key**：是一个路由规则，虚拟机可以用它来确定如何路由一个特定消息。消费者可能有多个，队列中的消息如果想要指定推送呢？就要通过这个key来查找投递给谁。
**Queue**：队列：也成为Message Queue,消息队列，保存消息并将它们转发给消费者。

#### 2.RabbitMQ的整体架构

![img](https://img-blog.csdnimg.cn/img_convert/e25102aafa5bf6e02f46d0554f70c020.png)

#### 3.RabbitMQ的运行流程

![img](https://img-blog.csdnimg.cn/img_convert/9d1972d3931c92e4b629d7bfc06c2608.png)

#### 4.RabbitMQ支持消息的模式

**消息的发送是通过交换机和exchage和queue进行绑定bind，然后指定相应的模式进行分发的。**

##### 4.1简单模式 Simple

##### 4.2工作模式 Work

- 类型：无
- 特点：分发机制

##### 4.3发布订阅模式

- 类型：fanout
- 特点：Fanout—发布与订阅模式，是一种广播机制，它是没有路由key的模式。
  绑定同一个交换机exchange的queue，在消息生产者将消息发送给exchange之后，所有的queue都会收到消息。
  ![image-20210522110435963](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522110435963.png)

##### 4.4路由模式

- 类型：direct

- 特点：有routing-key的匹配模式
  绑定同一个交换机exchange的queue，每一个queue都会有一个路由，当然，同一个路由下也可能有很多个queue，例如：

  Route : Queue
  email : queue1,queue2
  sms   : queue3
  wechat: queue4
  然后，交换机指定路由去发送消息，如果指定的路由是email，那么只有queue1和queue2会收到消息，其余不会。同理，如果路由是sms,那么queue3会收到消息，其余queue不会。
  ![image-20210522110611438](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522110611438.png)

##### 4.5主题Topic模式

- 类型：topic
- 特点：模糊的routing-key的匹配模式
  在路由模式的基础上增加了模糊匹配
  ![image-20210522105024395](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522105024395.png)
  **#代表零个或多个 比如com.xxx.xxx，也可以为空**
  ***代表至少要有一个，不能为空**
  com.course.order 这三个都会收到

##### 4.6参数模式

- 类型：headers
- 特点：参数匹配模式
  绑定时添加参数，按照参数进行匹配
  ![image-20210522110209340](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522110209340.png)
  发送消息时，指定参数条件
  ![image-20210522110317271](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522110317271.png)
  也就是x参数为1的队列才会收到

#### 5.小结

- rabbitmq发送消息一定有一个交换机
- 如果队列没有指定交换机会默认绑定一个交换机

![img](https://img-blog.csdnimg.cn/img_convert/a4b72392b64cf5df250b299cd4f84eaf.png)

![img](https://img-blog.csdnimg.cn/img_convert/564fbc73a98d40ea9206b29a4bf5e94b.png)

### RabbitMQ入门案例-fanout模式

#### 01、RabbitMQ的模式之发布订阅模式

![img](https://img-blog.csdnimg.cn/img_convert/437b731a80a2d4c65e2d24de0c6cad31.png)

##### 01-1、发布订阅模式具体实现

**生产者**

```java
package com.echo.fanout;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Producer {
    public static void main(String[] args) {
        //所有的中间价技术都是基于tcp/ip协议的，并在此协议上构建的。rabbitmq遵循的是amqp协议。
        //所以既然如此，必然会有ip和port
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.准备交换机
            String exchange = "fanout-exchange";    //提前在页面中定义好的
            //5.路由key
            String routeKey = "";
            //6.交换机类型
            String type = "fanout";
            //7.准备消息内容
            String message = "Hello world fanout";
            // 8: 发送消息给中间件rabbitmq-server
            // @params1: 交换机exchange
            // @params2: 队列名称/routingkey
            // @params3: 属性配置
            // @params4: 发送消息的内容

            /**
             * 为什么没有指定交换机exchange与queue的绑定关系呢？
             * 是因为在上述课程中，在web页面中已经将fanout-exchange与queue1,queue2,queue3绑定了。
             * 所以在此处不需要绑定了
             */


            channel.basicPublish(exchange, routeKey, null, message.getBytes());
            System.out.println("消息发送成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

```

**消费者**

```java
package com.echo.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    private static Runnable runnable = () -> {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //获取队列的名称
        final String queueName = Thread.currentThread().getName();
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Consumer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, false, false, null);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println(queueName + "：收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println(queueName + "：开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) {
        // 启动三个线程去执行,这三个queue是之前使用web界面操作时，定义好的。
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
    }
}
```

##### 01-2、发布订阅模式测试结果

![image-20210522113918846](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522113918846.png)

![image-20210522114251382](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522114251382.png)

### RabbitMQ入门案例 - Direct模式

#### 01、RabbitMQ的模式之Direct模式

![img](https://img-blog.csdnimg.cn/img_convert/4a1200407bb2b1a351cc2f601b6042f3.png)

##### 01-1、发布订阅模式具体实现

**生产者**

```java
package com.echo.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        //所有的中间价技术都是基于tcp/ip协议的，并在此协议上构建的。rabbitmq遵循的是amqp协议。
        //所以既然如此，必然会有ip和port
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.准备交换机
            String exchange = "direct-exchange";    //提前在页面中定义好的
            //5.路由key
            String routeKey = "email";
            String routeKey2 = "wechat";
            //6.交换机类型
            String type = "direct";
            //7.准备消息内容
            String message = "Hello world direct";
            // 8: 发送消息给中间件rabbitmq-server
            // @params1: 交换机exchange
            // @params2: 队列名称/routingkey
            // @params3: 属性配置
            // @params4: 发送消息的内容

            /**
             * 为什么没有指定交换机exchange与queue的绑定关系呢？
             * 是因为在上述课程中，在web页面中已经将direct-exchange与queue1,queue2,queue3绑定了。
             * 所以在此处不需要绑定了
             */


            channel.basicPublish(exchange, routeKey, null, message.getBytes());
            channel.basicPublish(exchange,routeKey2,null,message.getBytes());
            System.out.println("消息发送成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```

**消费者**

```java
package com.echo.direct;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    private static Runnable runnable = () -> {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //获取队列的名称
        final String queueName = Thread.currentThread().getName();
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Consumer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, false, false, null);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println(queueName + "：收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println(queueName + "：开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) {
        // 启动4个线程去执行,这4个queue是之前使用web界面操作时，定义好的。
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
        new Thread(runnable, "queue4").start();
    }
}
```

##### 01-2、测试结果

![image-20210522114311759](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522114311759.png)

![image-20210522114439872](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522114439872.png)

### RabbitMQ入门案例 - Topic模式

#### 01、RabbitMQ的模式之Topic模式

![img](https://img-blog.csdnimg.cn/img_convert/8afd6cf7c2bc96338d45dce37aa2abd9.png)

##### 01-1、发布订阅模式具体实现

**生产者**

```java
package com.echo.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        //所有的中间价技术都是基于tcp/ip协议的，并在此协议上构建的。rabbitmq遵循的是amqp协议。
        //所以既然如此，必然会有ip和port
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.准备交换机
            String exchange = "topic-exchange";    //提前在页面中定义好的
            //5.路由key
            String routeKey = "com.xxx.xxx";
            String routeKey2 = "com.course.order.";
            //6.交换机类型
            String type = "topic";
            //7.准备消息内容
            String message = "Hello world direct";
            // 8: 发送消息给中间件rabbitmq-server
            // @params1: 交换机exchange
            // @params2: 队列名称/routingkey
            // @params3: 属性配置
            // @params4: 发送消息的内容

            /**
             * 为什么没有指定交换机exchange与queue的绑定关系呢？
             * 是因为在上述课程中，在web页面中已经将direct-exchange与queue1,queue2,queue3绑定了。
             * 所以在此处不需要绑定了
             */


            channel.basicPublish(exchange, routeKey, null, message.getBytes());
            channel.basicPublish(exchange,routeKey2,null,message.getBytes());
            System.out.println("消息发送成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```

**消费者**

```java
package com.echo.topics;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    private static Runnable runnable = () -> {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //获取队列的名称
        final String queueName = Thread.currentThread().getName();
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Consumer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, false, false, null);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println(queueName + "：收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println(queueName + "：开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) {
        // 启动4个线程去执行,这4个queue是之前使用web界面操作时，定义好的。
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
        new Thread(runnable, "queue4").start();
    }
}
```

##### 01-2、测试结果

![image-20210522115439022](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522115439022.png)

![image-20210522115446611](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210522115446611.png)

### 完整的声明创建方式

#### 1.生产者

```java
package com.echo.all;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        //所有的中间价技术都是基于tcp/ip协议的，并在此协议上构建的。rabbitmq遵循的是amqp协议。
        //所以既然如此，必然会有ip和port
        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try{
            //2.创建Connection,名字叫做Producer
            connection = connectionFactory.newConnection("Producer");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.准备交换机名字
            String exchange = "direct-message-exchange";    //自己在代码中定义的
            //5.交换机类型
            String exchangeType = "direct";
            //6.在broker中声明交换机
            //第三个参数是交换机是否持久化，如果持久化 在broker关闭之后，该交换机也不会被移除
            channel.exchangeDeclare(exchange,exchangeType,true);
            //7.声明队列
            channel.queueDeclare("queue5",true,false,false,null);
            channel.queueDeclare("queue6",true,false,false,null);
            channel.queueDeclare("queue7",true,false,false,null);
            //8.绑定队列和交换机的关系,第三个参数是路由名字
            channel.queueBind("queue5",exchange,"order");
            channel.queueBind("queue6",exchange,"order");
            channel.queueBind("queue7",exchange,"course");

            //9.往队列里发送消息
            String messageOrder = "Hello direct All Order";
            String messageCourse = "Hello direct All Course";
            channel.basicPublish(exchange,"order",null,messageOrder.getBytes());
            channel.basicPublish(exchange,"course",null,messageCourse.getBytes());
            System.out.println("消息发送成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
```

发送完成后可以在web界面上查看

![image-20210524092059949](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524092059949.png)

![image-20210524092115300](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524092115300.png)

#### 2.消费者

消费者没有什么变化

```java
package com.echo.all;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    private static Runnable runnable = () -> {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //获取队列的名称
        final String queueName = Thread.currentThread().getName();
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Consumer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, false, false, null);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println(queueName + "：收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println(queueName + "：开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    public static void main(String[] args) {
        // 启动4个线程去执行,这4个queue是之前使用web界面操作时，定义好的。
        new Thread(runnable, "queue5").start();
        new Thread(runnable, "queue6").start();
        new Thread(runnable, "queue7").start();
    }
}
```

![image-20210524092238643](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524092238643.png)

### Work模式

![img](https://img-blog.csdnimg.cn/img_convert/61c80624fb855dcb45315e7d4a380e5a.png)

当有多个消费者时，我们的消息会被哪个消费者消费呢，我们又该如何均衡消费者消费信息的多少呢?
主要有两种模式：
1、轮询模式的分发：一个消费者一条，按均分配；
2、公平分发：根据消费者的消费能力进行公平分发，处理快的处理的多，处理慢的处理的少；按劳分配；

#### 1.Work轮询模式

- 特点：该模式接收消息是当有多个消费者接入时，消息的分配模式是一个消费者分配一条，直至消息消费完成；
- 轮询模式，并不会因为某个服务器的效率低而出现不均等分发的现象

##### 生产者

```java
package com.echo.work.round;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Producer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 6： 准备发送消息的内容
            //===============================end topic模式==================================
            for (int i = 1; i <= 20; i++) {
                //消息的内容
                String msg = "Echo:" + i;
                // 7: 发送消息给中间件rabbitmq-server
                // @params1: 交换机exchange
                // @params2: 队列名称/routingkey
                // @params3: 属性配置
                // @params4: 发送消息的内容
                channel.basicPublish("", "queue-work-round", null, msg.getBytes());
            }
            System.out.println("消息发送成功!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

![image-20210524093855188](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524093855188.png)

##### 消费者1

```java
package com.echo.work.round;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Work1 {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("消费者-Work1");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
//            channel.queueDeclare("queue1", false, false, false, null);
            // 同一时刻，服务器只会推送一条消息给消费者
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            //finalChannel.basicQos(1);
            finalChannel.basicConsume("queue-work-round", true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    try{
                        System.out.println("Work1-收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                        Thread.sleep(2000);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("Work1-开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

![image-20210524093952143](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524093952143.png)

##### 消费者2

```java
package com.echo.work.round;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Work2 {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("消费者-Work2");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, true, false, null);
            // 同一时刻，服务器只会推送一条消息给消费者
            //channel.basicQos(1);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            //finalChannel.basicQos(1);
            finalChannel.basicConsume("queue-work-round", true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    try{
                        System.out.println("Work2-收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                        Thread.sleep(200);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("Work2-开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

![image-20210524094001947](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524094001947.png)

#### 2.Work公平模式

##### 生产者

基本没有变化

```java
package com.echo.work.fair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("Producer");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 6： 准备发送消息的内容
            //===============================end topic模式==================================
            for (int i = 1; i <= 20; i++) {
                //消息的内容
                String msg = "Echo:" + i;
                // 7: 发送消息给中间件rabbitmq-server
                // @params1: 交换机exchange
                // @params2: 队列名称/routingkey
                // @params3: 属性配置
                // @params4: 发送消息的内容
                channel.basicPublish("", "queue-work-round", null, msg.getBytes());
            }
            System.out.println("消息发送成功!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

##### 消费者1

```java
package com.echo.work.fair;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Work1 {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("消费者-Work1");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
//            channel.queueDeclare("queue1", false, false, false, null);
            // 同一时刻，服务器只会推送一条消息给消费者
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            //设置每次消费的消息数量的指标，该参数的意思是，对于抢占到队列的消费者，每次消费队列中的一条消息
            //如果设置成其他数值，比如说20,那么某一个消费者抢占到队列之后，会直接消费队列中的20条消息。
            //所以该数值要根据业务场景中的实际情况来设置，如果设置过大，那么性能高的消费者会消费大量的消息
            finalChannel.basicQos(1);
            //第二个参数是应答方式，ture代表自动应答，false代表手动应答
            //由轮询方式改为公平方式，最重要的就是要修改这个应答机制。要将自动应答改为手动应答
            finalChannel.basicConsume("queue-work-round", false, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    try{
                        System.out.println("Work1-收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                        Thread.sleep(2000);
                        //手动应答,false代表单条消费
                        finalChannel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("Work1-开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

消费者中设置的一个重要的参数：

```
finalChannel.basicQos(1);
设置每次消费的消息数量的指标，该参数的意思是，对于抢占到队列的消费者，每次消费队列中的一条消息
如果设置成其他数值，比如说20,那么某一个消费者抢占到队列之后，会直接消费队列中的20条消息。
所以该数值要根据业务场景中的实际情况来设置，如果设置过大，那么性能高的消费者会消费大量的消息
```

##### 消费者2

```java
package com.echo.work.fair;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Work2 {
    public static void main(String[] args) {
        // 1: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2: 设置连接属性
        connectionFactory.setHost("192.168.45.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 3: 从连接工厂中获取连接
            connection = connectionFactory.newConnection("消费者-Work2");
            // 4: 从连接中获取通道channel
            channel = connection.createChannel();
            // 5: 申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, true, false, null);
            // 同一时刻，服务器只会推送一条消息给消费者
            //channel.basicQos(1);
            // 6： 定义接受消息的回调
            Channel finalChannel = channel;
            //设置每次消费的消息数量的指标，该参数的意思是，对于抢占到队列的消费者，每次消费队列中的一条消息
            //如果设置成其他数值，比如说20,那么某一个消费者抢占到队列之后，会直接消费队列中的20条消息。
            //所以该数值要根据业务场景中的实际情况来设置，如果设置过大，那么性能高的消费者会消费大量的消息
            finalChannel.basicQos(1);
            //第二个参数是应答方式，ture代表自动应答，false代表手动应答
            //由轮询方式改为公平方式，最重要的就是要修改这个应答机制。要将自动应答改为手动应答
            finalChannel.basicConsume("queue-work-round", false, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    try{
                        System.out.println("Work2-收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                        Thread.sleep(200);
                        //手动应答，false代表单条消费
                        finalChannel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("Work2-开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
```

总结一下，**公平分发就是要使用手动应答并设置Qos**,

**Qos的设置要根据磁盘空间等进行设置**

### RabbitMQ使用场景

#### 01、解耦、削峰、异步

##### 01-1、同步异步的问题（串行）

串行方式：将订单信息写入数据库成功后，发送注册邮件，再发送注册短信。以上三个任务全部完成后，返回给客户端，三个任务串行执行，只有三个任务全部完成，业务才能完成。

![img](https://img-blog.csdnimg.cn/img_convert/2bd296f7a65b8292b751b29869e65f45.png)

```java
public void makeOrder(){
    // 1 :保存订单 
    orderService.saveOrder();
    // 2： 发送短信服务
    messageService.sendSMS("order");//1-2 s
    // 3： 发送email服务
    emailService.sendEmail("order");//1-2 s
    // 4： 发送APP服务
    appService.sendApp("order");    
}
```

![image-20210524103052723](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524103052723.png)

代码中也存在事务问题，如果任何一个发送任务出错，都可能造成事务的回滚。

##### 01-2、并行方式 异步线程池

并行方式：将订单信息写入数据库成功后，发送注册邮件的同时，发送注册短信。以上三个任务完成后，返回给客户端。与串行的差别是，并行的方式可以提高处理的时间

![img](https://img-blog.csdnimg.cn/img_convert/f8127f0bdfd0e9ad7af4cdee57dea722.png)

```java
public void makeOrder(){
    // 1 :保存订单 
    orderService.saveOrder();
   // 相关发送
   relationMessage();
}
public void relationMessage(){
    // 异步
     theadpool.submit(new Callable<Object>{
         public Object call(){
             // 2： 发送短信服务  
             messageService.sendSMS("order");
         }
     })
    // 异步
     theadpool.submit(new Callable<Object>{
         public Object call(){
              // 3： 发送email服务
            emailService.sendEmail("order");
         }
     })
      // 异步
     theadpool.submit(new Callable<Object>{
         public Object call(){
             // 4： 发送短信服务
             appService.sendApp("order");
         }
     })
      // 异步
         theadpool.submit(new Callable<Object>{
         public Object call(){
             // 4： 发送短信服务
             appService.sendApp("order");
         }
     })
}
```

存在问题：
1：耦合度高
2：需要自己写线程池自己维护成本太高
3：出现了消息可能会丢失，需要你自己做消息补偿
4：如何保证消息的可靠性你自己写
5：如果服务器承载不了，你需要自己去写高可用

##### 01-3、异步消息队列的方式

![img](https://img-blog.csdnimg.cn/img_convert/668430cc2ff031d0e126cc1bde74ec4d.png)

**好处**
1：完全解耦，用MQ建立桥接
2：有独立的线程池和运行模型
3：出现了消息可能会丢失，MQ有持久化功能
4：如何保证消息的可靠性，死信队列和消息转移的等
5：如果服务器承载不了，你需要自己去写高可用，HA镜像模型高可用。
按照以上约定，用户的响应时间相当于是订单信息写入数据库的时间，也就是50毫秒。注册邮件，发送短信写入消息队列后，直接返回，因此写入消息队列的速度很快，基本可以忽略，因此用户的响应时间可能是50毫秒。因此架构改变后，系统的吞吐量提高到每秒20 QPS。比串行提高了3倍，比并行提高了两倍

```java
public void makeOrder(){
    // 1 :保存订单 
    orderService.saveOrder();   
    rabbitTemplate.convertSend("ex","2","消息内容");
}
```

#### 02、高内聚，低耦合

#### ![img](https://img-blog.csdnimg.cn/img_convert/d4863b2a59eec31fef88f9634df2267b.png)

#### 03、流量的削峰

![img](https://img-blog.csdnimg.cn/img_convert/531726aa415386fcf3793cac5ddcdfd1.png)

#### 04、分布式事务的可靠消费和可靠生产

#### 05、索引、缓存、静态化处理的数据同步

#### 06、流量监控

#### 07、日志监控（ELK）

#### 08、下单、订单分发、抢票

#### ...

### RabbitMQ-SpringBoot案例 -fanout模式

#### 整体核心

![img](https://img-blog.csdnimg.cn/img_convert/0e5b0cad8b1c8ce8d1e17b4078f1bf8d.png)

#### 01、目标

使用springboot完成rabbitmq的消费模式-Fanout

![img](https://img-blog.csdnimg.cn/img_convert/66db3c8d3a5f9a6045c96f9e22566066.png)

#### 02、实现步骤

1：创建生产者工程：springboot-rabbitmq-fanout-producer
2：创建消费者工程：springboot-rabbitmq-fanout-consumer
3：引入spring-boot-rabbitmq的依赖
4：进行消息的分发和测试
5：查看和观察web控制台的状况

#### 03、生产者

##### 1、创建生产者工程：springboot-order-rabbitmq-fanout-producer

![image-20210524110959177](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524110959177.png)

##### 2、在pom.xml中引入依赖

```xml
    <dependencies>
<!--        rabbit-starter 依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

##### 3、在application.yml进行配置

```yml
server:
  port: 8080

spring:
  rabbitmq:
    username: admin
    password: admin
    virtual-host: /
    host: 192.168.45.135
    port: 5672
```

##### 4：定义订单的生产者

```java
package com.echo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "fanout-order-exchange";  //交换机名称
        String routeKey = "";   //路由key

        /**
         * 队列与交换机的绑定等配置在配置类中完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey,orderId);
    }
}
```

##### 5：定义配置类

```java
package com.echo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    //1.声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new FanoutExchange("fanout-order-exchange",true,false);
    }
    //2.声明队列sms.fanout.queue, email.fanout.queue, wechat.fanout.queue
    @Bean
    public Queue smsQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("sms-fanout-queue",true);
    }
    @Bean
    public Queue emailQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("email-fanout-queue",true);
    }
    @Bean
    public Queue wechatQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("wechat-fanout-queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding wechatBinding(){
        return BindingBuilder.bind(wechatQueue()).to(fanoutExchange());
    }
}

```

##### 6：测试类

```java
@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }

}
```

##### 7: 测试结果

![image-20210524201614905](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524201614905.png)

![image-20210524201645197](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524201645197.png)

成功绑定，并发送消息

#### 04.消费者

##### 1、创建消费者工程：springboot-order-rabbitmq-fanout-consumer

![image-20210524202249522](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524202249522.png)

##### 2.pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.6</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.echo</groupId>
    <artifactId>springboot-order-rabbitmq-fanout-consumer</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-order-rabbitmq-fanout-consumer</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

##### 3.application.yml

```yml
server:
  port: 8081

spring:
  rabbitmq:
    username: admin
    password: admin
    virtual-host: /
    host: 192.168.45.135
    port: 5672
```

##### 4.创建三个消费者

![image-20210524202456361](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524202456361.png)

##### 5.编写代码

```java
package com.echo.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email-fanout-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class FanoutEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email fanout -- 接收到了消息: " + message);
    }
}

```

```java
package com.echo.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms-fanout-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class FanoutSMSConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("SMS fanout -- 接收到了消息: " + message);
    }
}

```

```java
package com.echo.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"wechat-fanout-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class FanoutWechatConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("WeChat fanout -- 接收到了消息: " + message);
    }
}

```

##### 6.启动springboot观察结果

![image-20210524203208316](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524203208316.png)

**可以发现很神奇的一件事情，那就是不要其他任何配置，只要启动了这边的消费者服务，只要发送方一发送，这边就可以监听到，并输出消息**

### RabbitMQ入门案例 - Direct模式

#### 01、RabbitMQ的模式之Direct模式

![img](https://img-blog.csdnimg.cn/img_convert/4a1200407bb2b1a351cc2f601b6042f3.png)

#### 01-1、发布订阅模式具体实现

- 类型：direct
- 特点：Direct模式是fanout模式上的一种叠加，增加了路由RoutingKey的模式。

##### 生产者

新增配置类

**注：这个配置类其实可以定义在生产者处，也可以定义在消费者处，定义在哪里，就先启动哪里，这样就会生成相应的交换机和队列，其实最好的方式是定义在消费者处，因为消费者是直接与队列进行打交道的，在使用之前一定要保证队列和交换机的初始化**

```java
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfiguration {
    //1.声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new DirectExchange("direct-order-exchange",true,false);
    }
    //2.声明队列sms.direct.queue, email.direct.queue, wechat.direct.queue
    @Bean
    public Queue smsDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("sms-direct-queue",true);
    }
    @Bean
    public Queue emailDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("email-direct-queue",true);
    }
    @Bean
    public Queue wechatDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("wechat-direct-queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("email");
    }
    @Bean
    public Binding wechatDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(wechatDirectQueue()).to(directExchange()).with("wechat");
    }
}

```

在OrderService中新增一个direct的方法，使用direct模式发送消息

```java
package com.echo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrderFanout(String userId, String productId, Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "fanout-order-exchange";  //交换机名称
        String routeKey = "";   //路由key

        /**
         * 队列与交换机的绑定等配置在配置类RabbitMQConfiguration中完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey,orderId);
    }

    public void makeOrderDirect(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功direct.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "direct-order-exchange";  //交换机名称
        String routeKey1 = "sms";   //路由key
        String routeKey2 = "email";

        /**
         * 队列与交换机的绑定等配置在配置类RabbitMQConfiguration中完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
        rabbitTemplate.convertAndSend(exchangeName,routeKey2,orderId);
    }
}

```

##### 消费者

![image-20210524210157391](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524210157391.png)

```java
@RabbitListener(queues = {"email-direct-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class DirectEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email direct -- 接收到了消息: " + message);
    }
}

```

```java
@RabbitListener(queues = {"sms-direct-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class DirectSMSConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("SMS direct -- 接收到了消息: " + message);
    }
}

```

```java
@RabbitListener(queues = {"wechat-direct-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class DirectWechatConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("WeChat direct -- 接收到了消息: " + message);
    }
}

```

##### 启动测试

因为这边配置类定义在生产者，因此需要先启动生产者。

```java
@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void testFanout() {
        orderService.makeOrderFanout("1","1",12);
    }

    @Test
    void testDirect(){
        orderService.makeOrderDirect("2","2",13);
    }
}

```

启动生产者

![image-20210524210743745](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524210743745.png)

启动消费者

![image-20210524211005637](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524211005637.png)

因为只给两个路由发送了消息，所以只有两个会收到

### RabbitMQ入门案例 - Topic模式

#### 01.生产者

只修改OrderService中的代码，交换机与队列的绑定在消费者部分做

```java
public void makeOrderTopic(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功direct.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "topic-order-exchange";  //交换机名称
        String routeKey1 = "com.email.xxx";
        String routeKey2 = "org.wechat.cc";
        /**
         * 队列与交换机的绑定等在消费方，使用注解完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
        rabbitTemplate.convertAndSend(exchangeName,routeKey2,orderId);
    }
```

```java
    @Test
    void testTopic(){
        orderService.makeOrderTopic("3","3",14);
    }
```

#### 02.消费者

消费者在启动时，使用注解进行交换机和队列的绑定

![image-20210524212843570](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524212843570.png)

```java
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email-topic-queue",durable = "true",autoDelete = "false"), //绑定的队列
        exchange = @Exchange(value = "topic-order-exchange",type = ExchangeTypes.TOPIC), //绑定的交换机
        key = "*.email.*" //路由key
))
@Component
public class TopicEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email topic -- 接收到了消息: " + message);
    }
}

```

```java
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms-topic-queue",durable = "true",autoDelete = "false"), //绑定的队列
        exchange = @Exchange(value = "topic-order-exchange",type = ExchangeTypes.TOPIC), //绑定的交换机
        key = "#.sms.#" //路由key
))
@Component
public class TopicSMSConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("SMS topic -- 接收到了消息: " + message);
    }
}

```

```java
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "wechat-topic-queue",durable = "true",autoDelete = "false"), //绑定的队列
        exchange = @Exchange(value = "topic-order-exchange",type = ExchangeTypes.TOPIC), //绑定的交换机
        key = "#.wechat.#" //路由key
))
@Component
public class TopicWechatConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("WeChat topic -- 接收到了消息: " + message);
    }
}

```

#### 03.测试

先启动消费者,再启动生产者，然后进行测试

![image-20210524213325198](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524213325198.png)

### RabbitMQ高级-过期时间TTL

#### 1、概述

过期时间TTL表示可以对消息设置预期的时间，在这个时间内都可以被消费者接收获取；过了之后消息将自动被删除。RabbitMQ可以对**消息和队列**设置TTL。目前有两种方法可以设置。

- 第一种方法是通过队列属性设置，队列中所有消息都有相同的过期时间。
- 第二种方法是对消息进行单独设置，每条消息TTL可以不同。

如果上述两种方法同时使用，则消息的过期时间以两者之间TTL较小的那个数值为准。消息在队列的生存时间一旦超过设置的TTL值，就称为dead message被投递到死信队列， 消费者将无法再收到该消息。

#### 2.消费者设置队列TTL

在消费者处进行配置，通过一个配置类，定义一个TTL的队列，并进行配置。

![image-20210524214317034](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524214317034.png)

```java
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitMQConfiguration {

    @Bean
    public DirectExchange ttlDirectExchange(){
        //定义一个交换机
        return new DirectExchange("ttl-direct-exchange",true,false);
    }

    @Bean
    public Queue directTTLQueue(){
        //定义一个ttl的队列
        Map<String,Object> args = new HashMap<>();
        //参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
        //以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。
        args.put("x-message-ttl",5000);
        return new Queue("ttl-direct-queue",true,false,false,args);
    }

    @Bean
    public Binding directTTLBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(ttlDirectExchange()).with("ttl");
    }
}

```

```
参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。
```

#### 3.生产者代码

OrderService中

```java
    public void makeOrderTTL(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功TTL.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "ttl-direct-exchange";  //交换机名称
        String routeKey1 = "ttl";
        /**
         * 队列与交换机的绑定等在消费方
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
    }
```

test中

```java
@Test
    void testTTL(){
        orderService.makeOrderTopic("4","4",15);
    }
```

#### 4.启动测试



先启动消费者，再启动生产者

启动生产者生产消息后，5秒内没有消费消息的话，消息就没了

![image-20210524215453735](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524215453735.png)



![image-20210524215510373](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524215510373.png)

然后在在消费者方添加消费代码。

```java
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"ttl-direct-queue"})
public class TTLDirectConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("TTL direct -- 接收到了消息: " + message);
    }
}
```

启动服务方，然后启动测试方

![image-20210524222851228](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210524222851228.png)

#### 5.设置消息的过期时间

在消费方的TTLRabbitMQConfiguration配置中新增一个directQueue，并不设置其过期时间

```java
    @Bean
    public Queue directTTLMessageQueue(){
        return new Queue("ttl-direct-message-queue",true);
    }

    @Bean
    public Binding directTTLMessageBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(ttlDirectExchange()).with("ttlMessage");
    }
```

在消费方发送消息，在OrderService中发送消息，并指定消息的过期时间

```java
public void makeOrderTTLMessage(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功TTLMessage.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "ttl-direct-exchange";  //交换机名称
        String routeKey1 = "ttlMessage";
        /**
         * 队列与交换机的绑定等在消费方
         */
        //给消息设置过期时间
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置过期时间5秒
                message.getMessageProperties().setExpiration("5000");
                message.getMessageProperties().setContentEncoding("UTF-8");
                return message;
            }
        };

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId,messagePostProcessor);
    }
```

在消费方的测试类中，添加测试代码

```java
    @Test
    void testTTLMessage(){
        orderService.makeOrderTTLMessage("5","5",16);
    }
```

测试

![image-20210525212658886](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525212658886.png)

### RabbitMQ高级-死信队列

#### 1.概述

DLX，全称为Dead-Letter-Exchange , 可以称之为死信交换机，也有人称之为死信邮箱。当消息在一个队列中变成死信(dead message)之后，它能被重新发送到另一个交换机中，这个交换机就是DLX ，绑定DLX的队列就称之为死信队列。
消息变成死信，可能是由于以下的原因：

- 消息被拒绝
- 消息过期
- 队列达到最大长度

DLX也是一个正常的交换机，和一般的交换机没有区别，它能在任何的队列上被指定，实际上就是设置某一个队列的属性。当这个队列中存在死信时，Rabbitmq就会自动地将这个消息重新发布到设置的DLX上去，进而被路由到另一个队列，即死信队列。
要想使用死信队列，只需要在定义队列的时候设置队列参数 `x-dead-letter-exchange` 指定交换机即可。

![img](https://img-blog.csdnimg.cn/img_convert/3f9a11d5ee5f8d74f49e82869408bb78.png)

#### 2.消费者处定义一个死信队列的配置

![image-20210525213843503](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525213843503.png)

声明一个direct类型的死信交换机，并声明一个队列与交换机绑定

```java
@Configuration
public class DeadRabbitMQConfiguration {
    //1.声明注册direct模式的死信交换机
    @Bean
    public DirectExchange deadDirectExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new DirectExchange("dead-direct-exchange",true,false);
    }

    //2.在死信交换机中声明一个死信队列
    @Bean
    public Queue deadQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("dead-direct-queue",true);
    }
    
    //3.绑定队列和交换机
    @Bean
    public Binding deadBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange()).with("dead");
    }
}
```

在ttl-direct-exchange中设置死信交换机，和死信队列，让超过队列过期时间的消息放到死信队列中

```java
@Configuration
public class TTLRabbitMQConfiguration {

    @Bean
    public DirectExchange ttlDirectExchange(){
        //定义一个交换机
        return new DirectExchange("ttl-direct-exchange",true,false);
    }

    @Bean
    public Queue directTTLQueue(){
        //定义一个ttl的队列
        Map<String,Object> args = new HashMap<>();
        //参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
        //以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。
        args.put("x-message-ttl",5000);
        //设置死信交换机，过期后的时间交给死信交换机
        args.put("x-dead-letter-exchange","dead-direct-exchange");
        //设置死信交换机中的死信队列的路由值
        args.put("x-dead-letter-routing-key","dead");
        return new Queue("ttl-direct-queue",true,false,false,args);
    }

    @Bean
    public Binding directTTLBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(ttlDirectExchange()).with("ttl");
    }
}

```

![image-20210525214810924](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525214810924.png)

#### 3.测试

![image-20210525215528125](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525215528125.png)

测试会报错是因为

```java
@Bean
    public Queue directTTLQueue(){
        //定义一个ttl的队列
        Map<String,Object> args = new HashMap<>();
        //参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
        //以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。
        args.put("x-message-ttl",5000);
        //设置死信交换机，过期后的时间交给死信交换机
        args.put("x-dead-letter-exchange","dead-direct-exchange");
        //设置死信交换机中的死信队列的路由值
        args.put("x-dead-letter-routing-key","dead");
        return new Queue("ttl-direct-queue",true,false,false,args);
    }
```

原来已经有了directTTLQueue,然后我们又修改了参数，重新创建它，这里的参数修改不会应用到该queue上，所以会报错，解决的办法就是在web页面中删掉这个queue，或者重新在代码中定义一个新的queue，实际上线环境中遇到这种情况，一定要重新定义一个queue而不要随意删除原来的queue，

设置好之后

![image-20210525224639319](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525224639319.png)

发送一条消息到ttl队列中

```java
    @Test
    void testTTL(){
        orderService.makeOrderTTL("4","4",15);
    }
```

![image-20210525224840049](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525224840049.png)

5秒后发现ttl队列中没有了消息，放到了死信队列中

![image-20210525224917562](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525224917562.png)

#### 4.同理可以设置最大队列长度，超过长度的消息会放到死信队列中

```java
@Bean
    public Queue directTTLQueue(){
        //定义一个ttl的队列
        Map<String,Object> args = new HashMap<>();
        //参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
        //以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。过期放到死信队列
        args.put("x-message-ttl",5000);
        //设置最大队列长度为5，超过此长度会放到死信队列
        args.put("x-max-length",5);
        //设置死信交换机，过期后的时间交给死信交换机
        args.put("x-dead-letter-exchange","dead-direct-exchange");
        //设置死信交换机中的死信队列的路由值
        args.put("x-dead-letter-routing-key","dead");
        return new Queue("ttl-direct-queue",true,false,false,args);
    }
```

#### 5.工作流程

![img](https://img-blog.csdnimg.cn/img_convert/df6ca1a36687ccfc9dfbbfb81a8dd2e6.png)

应用场景：延迟队列，下单后一定时间内没有结账，订单移到死信队列中，死信队列的消费者再消费

### RabbitMQ运维-持久化机制和内存磁盘的监控

#### 01、RibbitMQ持久化

持久化就把信息写入到磁盘的过程

#### 02、RabbitMQ持久化消息

![img](https://img-blog.csdnimg.cn/img_convert/8c010be41c1868eb4d0ca534f8730c2a.png)

把消息默认放在内存中是为了加快传输和消费的速度，存入磁盘是保证消息数据的持久化。

#### 03、RabbitMQ非持久化消息

非持久消息：是指当内存不够用的时候，会把消息和数据转移到磁盘，但是重启以后非持久化队列消息就丢失。

#### 04、RabbitMQ持久化分类

RabbitMQ的持久化队列分为：
1：队列持久化
2：消息持久化
3：交换机持久化
不论是持久化的消息还是非持久化的消息都可以写入到磁盘中，只不过非持久的是等内存不足的情况下才会被写入到磁盘中。

#### 05、RabbitMQ队列持久化的代码实现

```java
// 参数1：名字  
// 参数2：是否持久化，
// 参数3：独du占的queue， 
// 参数4：不使用时是否自动删除，
// 参数5：其他参数
channel.queueDeclare(queueName,true,false,false,null);
```

其中参数2：设置为true就代表的是持久化的含义。即durable=true。持久化的队列在web控制台中有一个`D` 的标记

##### 测试步骤

1：可以建立一个临时队列

![img](https://img-blog.csdnimg.cn/img_convert/a3e24f6b60f33d87e6bb6982be9933c4.png)

2：然后重启rabbit-server服务，会发现持久化队列依然在，而非持久队列会丢失。

#### 06、RabbitMQ消息持久化

消息持久化是通过消息的属性deliveryMode来设置是否持久化，在发送消息时通过basicPublish的参数传入。

```java
// 参数1：交换机的名字
// 参数2：队列或者路由key
// 参数3：是否进行消息持久化
// 参数4：发送消息的内容
channel.basicPublish(exchangeName, routingKey1, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());xxxxxxxxxx // 参数1：交换机的名字// 参数2：队列或者路由key// 参数3：是否进行消息持久化// 参数4：发送消息的内容channel.basicPublish(exchangeName, routingKey1, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());// 参数1：交换机的名字// 参数2：队列或者路由key// 参数3：是否进行消息持久化// 参数4：发送消息的内容channel.basicPublish(exchangeName, routingKey1, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
```

#### 07、RabbitMQ交换机持久化

和队列一样，交换机也需要在定义的时候设置持久化的标识，否则在rabbit-server服务重启以后将丢失。

```java
// 参数1：交换机的名字
// 参数2：交换机的类型，topic/direct/fanout/headers
// 参数3：是否持久化
channel.exchangeDeclare(exchangeName,exchangeType,true);
```

### RabbitMQ运维-内存磁盘的监控

#### 01、RabbitMQ的内存警告

当内存使用超过配置的阈值或者磁盘空间剩余空间对于配置的阈值时，RabbitMQ会暂时阻塞客户端的连接，并且停止接收从客户端发来的消息，以此避免服务器的崩溃，客户端与服务端的心态检测机制也会失效。

![image-20210525231406963](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210525231406963.png)如下图：

![img](https://img-blog.csdnimg.cn/img_convert/828b2beac8cdc3e138f532b2e3720c3d.png)

#### 02、RabbitMQ的内存控制

参考帮助文档：https://www.rabbitmq.com/configure.html
当出现警告的时候，可以通过配置去修改和调整

##### 02-1、命令的方式

```bash
rabbitmqctl set_vm_memory_high_watermark relative 0.6	#相对值百分比
rabbitmqctl set_vm_memory_high_watermark absolute 50MB	#绝对值
```

fraction/value 为内存阈值。默认情况是：0.4/2GB，代表的含义是：当RabbitMQ的内存超过40%时，就会产生警告并且阻塞所有生产者的连接。通过此命令修改阈值在Broker重启以后将会失效，通过修改配置文件方式设置的阈值则不会随着重启而消失，但修改了配置文件一样要重启broker才会生效。

分析：

执行命令

```bash
rabbitmqctl set_vm_memory_high_watermark absolute 50MB
```

![img](https://img-blog.csdnimg.cn/img_convert/15beb8284b55772d277df67ca2deec52.png)

**这个命令设置的是报警的极限值，而不是设置的rabbitMQ所使用的内存的值，意思是内存使用超过50MB之后报警**

##### vm_memory_high_watermark

这个是与流量控制相关的内存参数.RabbitMQ会在启动和执行命令`rabbitmqctl set_vm_memory_high_watermark 百分比`的时候检测系统所安装的内存总量。默认情况下，当RabbitMQ服务器使用超过`40%`的内存时，它会引起一个内存报警并且`阻塞所有连接`。一旦内存报警清除后（例如，由于RabbitMQ服务器将消息页交换到磁盘或者分发到客户端时）就会恢复正常服务了。

所以，将这个值设置为`0`,然后它就会立即触发内存报警！如果你希望允许RabbitMQ使用更加多的内存，它可以增大该值.

**另一个重要的事项：**

默认的内存阀值是 40% 的系统安装的内存。请注意，该值并不是防止RabbitMQ服务器使用超过40%的内存，它仅仅只是指明生产者(publishers)会进行节流（流量控制）

所以，如果你在引起内存报警的时候尝试发送消息，在进行发送期间就会被阻塞了。

如果你想阻塞所有的发送者，你可以将该参数 `vm_memory_high_watermark` 设置为0.

如果你想`禁止`基于内存的流量控制，你可以将该参数`vm_memory_high_watermark` 设置为100。

##### vm_memory_limit

这个值，默认就是 `vm_memory_high_watermark * installed memory`（如果设置的是百分比参数的话）

可使用内存上限。注意，如果 `vm_memory_high_watermark` 生效的话，那MQ是有可能超过这个值的（上下波动）

如果 `vm_memory_high_watermark` 设置的是绝对值的话，那`vm_memory_limit = vm_memory_high_watermark`。

![img](https://img-blog.csdnimg.cn/img_convert/79aba8be0d9a539b84395c686fad0f61.png)

消费者都已经阻塞了

##### 02-2、配置文件方式 rabbitmq.conf

找自己配置文件：/xxx/xxxx/rabbitmq.conf 的位置

```bash
#默认
#vm_memory_high_watermark.relative = 0.4
# 使用relative相对值进行设置fraction,建议取值在04~0.7之间，不建议超过0.7.
vm_memory_high_watermark.relative = 0.6
# 使用absolute的绝对值的方式，但是是KB,MB,GB对应的命令如下
vm_memory_high_watermark.absolute = 2GB
```

#### 03、RabbitMQ的磁盘预警

当磁盘的剩余空间低于确定的阈值时，RabbitMQ同样会阻塞生产者，这样可以避免因非持久化的消息持续换页而耗尽磁盘空间导致服务器崩溃。

默认情况下：磁盘预警为50MB的时候会进行预警，**即剩余内存空间不足50MB时，会发生报警**。表示当前磁盘空间第50MB的时候会阻塞生产者并且停止内存消息换页到磁盘的过程。
这个阈值可以减小，但是不能完全的消除因磁盘耗尽而导致崩溃的可能性。比如在两次磁盘空间的检查空隙内，第一次检查是：60MB ，第二检查可能就是1MB,就会出现警告。

通过命令方式修改如下：

```bash
rabbitmqctl set_disk_free_limit  <disk_limit>
rabbitmqctl set_disk_free_limit memory_limit  <fraction>
disk_limit：固定单位 KB MB GB
fraction ：是相对阈值，建议范围在:1.0~2.0之间。（相对于内存）
```

通过配置文件配置如下：

```bash
disk_free_limit.relative = 3.0
disk_free_limit.absolute = 50mb
```



#### 04、RabbitMQ的内存换页

在某个Broker节点及内存阻塞生产者之前，它会尝试将队列中的消息换页到磁盘以释放内存空间，持久化和非持久化的消息都会写入磁盘中，其中持久化的消息本身就在磁盘中有一个副本，所以在转移的过程中持久化的消息会先从内存中清除掉。

默认情况下，内存到达的阈值是50%时就会换页处理。
也就是说，在默认情况下该内存的阈值是0.4的情况下，当内存超过0.4*0.5=0.2时，会进行换页动作。

比如：**内存为8G，阈值为0.4，超过 8 * 0.4 = 3.2G的时候，会发生报警。但是超过 3.2G * 0.5 = 1.6G之后，会发生换页。**

比如有1000MB内存，当内存的使用率达到了400MB,已经达到了极限，但是因为配置的换页内存0.5，这个时候会在达到极限400mb之前，会把内存中的200MB进行转移到磁盘中。从而达到稳健的运行。

可以通过设置 `vm_memory_high_watermark_paging_ratio` 来进行调整

```bash
vm_memory_high_watermark.relative = 0.4  #阈值
vm_memory_high_watermark_paging_ratio = 0.7（设置小于1的值）#换页百分比
```

为什么设置小于1，以为你如果你设置为1的阈值。内存都已经达到了极限了。你在去换页意义不是很大了。

### RabbitMQ-高级-集群

**我这里是用ubuntu搭建的，内容和视频中不太一样。**

#### 01、RabbitMQ 集群

RabbitMQ这款消息队列中间件产品本身是基于Erlang编写，Erlang语言天生具备分布式特性（通过同步Erlang集群各节点的magic cookie来实现）。因此，RabbitMQ天然支持Clustering。这使得RabbitMQ本身不需要像ActiveMQ、Kafka那样通过ZooKeeper分别来实现HA方案和保存集群的元数据。集群是保证可靠性的一种方式，同时可以通过水平扩展以达到增加消息吞吐量能力的目的。
在实际使用过程中多采取多机多实例部署方式，为了便于同学们练习搭建，有时候你不得不在一台机器上去搭建一个rabbitmq集群，本章主要针对单机多实例这种方式来进行开展。

#### 02、集群搭建

配置的前提是你的rabbitmq可以运行起来，比如”ps aux|grep rabbitmq”你能看到相关进程，又比如运行“rabbitmqctl status”你可以看到类似如下信息，而不报错：

执行下面命令进行查看：

```bash
ps aux|grep rabbitmq
```

发现它在运行

![image-20210526211334029](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526211334029.png)

或者使用

```bash
systemctl status rabbitmq-server
```

![image-20210526211424800](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526211424800.png)

##### 停掉rabbitMQ

```bash
systemctl stop rabbitmq-server
```

![image-20210526211523414](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526211523414.png)

然后再检查

![image-20210526211600893](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526211600893.png)

发现停止成功

#### 03、单机多实例搭建

**场景：**假设有两个rabbitmq节点，分别为rabbit-1, rabbit-2，rabbit-1作为主节点，rabbit-2作为从节点。

##### 03-1、**第一步**：启动第一个节点rabbit-1

**启动命令**：sudo RABBITMQ_NODE_PORT=5672 RABBITMQ_NODENAME=rabbit-1 rabbitmq-server start &

![image-20210526212055172](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526212055172.png)

至此节点rabbit-1启动完成

**结束命令**：sudo rabbitmqctl -n rabbit-1 stop

##### 03-2、启动第二个节点rabbit-2

注意：web管理插件端口占用,所以还要指定其web插件占用的端口号
RABBITMQ_SERVER_START_ARGS=”-rabbitmq_management listener [{port,15673}]”

**启动命令**：sudo RABBITMQ_NODE_PORT=5673 RABBITMQ_SERVER_START_ARGS="-rabbitmq_management listener [{port,15673}]" RABBITMQ_NODENAME=rabbit-2 rabbitmq-server start &

![image-20210526213343711](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526213343711.png)

至此节点rabbit-2启动完成。

##### 03-3、验证启动 “ps aux|grep rabbitmq”

```
ps aux|grep rabbitmq
```

![image-20210526212931821](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526212931821.png)

![image-20210526212913721](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526212913721.png)

##### 03-4、rabbit-1操作作为主节点

```bash
#停止应用
> sudo rabbitmqctl -n rabbit-1 stop_app
#目的是清除节点上的历史数据（如果不清除，无法将节点加入到集群）
> sudo rabbitmqctl -n rabbit-1 reset
#启动应用
> sudo rabbitmqctl -n rabbit-1 start_app
```

![image-20210526213057096](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526213057096.png)

##### 03-5、rabbit2操作为从节点

```bash
# 停止应用
> sudo rabbitmqctl -n rabbit-2 stop_app
# 目的是清除节点上的历史数据（如果不清除，无法将节点加入到集群）
> sudo rabbitmqctl -n rabbit-2 reset
# 将rabbit2节点加入到rabbit1（主节点）集群当中【Server-node服务器的主机名】
> 例：sudo rabbitmqctl -n rabbit-2 join_cluster rabbit-1@Server-node #这个Server-node
#是你的主机名  可以在控制台看echo@echo-machine:~$  我的命令行的主机名就是echo-machine
> sudo rabbitmqctl -n rabbit-2 join_cluster rabbit-1@echo-machine
# 启动应用
> sudo rabbitmqctl -n rabbit-2 start_app
```

![image-20210526214042655](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526214042655.png)

![image-20210526214132889](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526214132889.png)

##### 03-6、验证集群状态

```bash
sudo rabbitmqctl cluster_status -n rabbit-1
```

![image-20210526214249426](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526214249426.png)

可以看到有两个节点在运行，并构成了一个集群

##### 03-7、Web监控

![img](https://img-blog.csdnimg.cn/img_convert/4fecb3c7fd25fd681d4b5744fe03704e.png)

首先打开页面管理

```bash
sudo rabbitmq-plugins enable rabbitmq_management
```

![image-20210526214845765](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526214845765.png)

有如下提示，就是已经开启过了

![image-20210526215018117](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215018117.png)

![image-20210526215033849](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215033849.png)

注意在访问的时候：web界面的管理需要给15672 node-1 和15673的node-2 设置用户名和密码。否则是无法访问的。

如下:

```bash
sudo rabbitmqctl -n rabbit-1 add_user admin admin
sudo rabbitmqctl -n rabbit-1 set_user_tags admin administrator
sudo rabbitmqctl -n rabbit-1 set_permissions -p / admin ".*" ".*" ".*"

sudo rabbitmqctl -n rabbit-2 add_user admin admin
sudo rabbitmqctl -n rabbit-2 set_user_tags admin administrator
sudo rabbitmqctl -n rabbit-2 set_permissions -p / admin ".*" ".*" ".*"
```

![image-20210526215241054](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215241054.png)

rabbit-2也一样

![image-20210526215335318](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215335318.png)

#### 03-8、测试

在从节点创建一个队列

![image-20210526215621734](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215621734.png)

在主节点也可以看到

![image-20210526215659496](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215659496.png)

**同样的，在从创建队列，在主创建交换机，然后绑定队列也是可以的，说白了就是在哪边操作都一样**



**从节点挂掉**

sudo rabbitmqctl -n rabbit-2 stop_app

![image-20210526215912794](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215912794.png)

![image-20210526215931981](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215931981.png)

![image-20210526215952031](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526215952031.png)

**重启从节点，挂掉主节点**

sudo rabbitmqctl -n rabbit-2 start_app

sudo rabbitmqctl -n rabbit-1 stop_app

![image-20210526220110544](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526220110544.png)

![image-20210526220136730](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526220136730.png)

![image-20210526220151580](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526220151580.png)

![image-20210526220327645](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526220327645.png)

可以发现，**挂掉了主节点，队列也就挂掉了，就不会消息了，集群就无法使用了，必须等到主节点启动**

### 03-9、小结

**Tips：**
如果采用多机部署方式，需读取其中一个节点的cookie, 并复制到其他节点（节点之间通过cookie确定相互是否可通信）。

![image-20210526221002408](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526221002408.png)

cookie存放在/var/lib/rabbitmq/.erlang.cookie。
例如：主机名分别为rabbit-1、rabbit-2
1、逐个启动各节点
2、配置各节点的hosts文件( vim /etc/hosts)
 ip1：rabbit-1
 ip2：rabbit-2

3、配置从节点的主节点时，ServerNode要换成主机的IP，或者主机IP映射的别名

```bash
sudo rabbitmqctl -n rabbit-2 join_cluster rabbit-1@Server-node
```

其它步骤雷同单机部署方式

### RabbitMQ-高级-分布式事务

#### 简述

分布式事务指事务的操作位于不同的节点上，需要保证事务的 AICD 特性。
例如在下单场景下，库存和订单如果不在同一个节点上，就涉及分布式事务,分布式事务指的就是跨JVM级别的事务。

![image-20210526221908479](C:\Users\Echo\AppData\Roaming\Typora\typora-user-images\image-20210526221908479.png)

#### 01、分布式事务的方式

在分布式系统中，要实现分布式事务，无外乎那几种解决方案

##### 一、两阶段提交（2PC）需要数据库产商的支持，java组件有atomikos等

两阶段提交（Two-phase Commit，2PC），通过引入协调者（Coordinator）来协调参与者的行为，并最终决定这些参与者是否要真正执行事务。

###### 准备阶段

协调者询问参与者事务是否执行成功，参与者发回事务执行结果。

![img](https://img-blog.csdnimg.cn/img_convert/2a741e5632f5a2fb7e1a731b550528b5.png)

######  提交阶段

如果事务在每个参与者上都执行成功，事务协调者发送通知让参与者提交事务；否则，协调者发送通知让参与者回滚事务。
需要注意的是，在准备阶段，参与者执行了事务，但是还未提交。只有在提交阶段接收到协调者发来的通知后，才进行提交或者回滚

![img](https://img-blog.csdnimg.cn/img_convert/e0e14869474b90f49e906f3201520279.png)

###### 存在的问题

- 同步阻塞 所有事务参与者在等待其它参与者响应的时候都处于同步阻塞状态，无法进行其它操作
- 单点问题 协调者在 2PC 中起到非常大的作用，发生故障将会造成很大影响。特别是在阶段二发生故障，所有参与者会一直等待状态，无法完成其它操作。
- 数据不一致 在阶段二，如果协调者只发送了部分 Commit 消息，此时网络发生异常，那么只有部分参与者接收到 Commit 消息，也就是说只有部分参与者提交了事务，使得系统数据不一致。
- 太过保守 任意一个节点失败就会导致整个事务失败，没有完善的容错机制。

##### 二、补偿事务（TCC） 严选，阿里，蚂蚁金服。

TCC 其实就是采用的补偿机制，其核心思想是：针对每个操作，都要注册一个与其对应的确认和补偿（撤销）操作。它分为三个阶段：

- Try 阶段主要是对业务系统做检测及资源预留
- Confirm 阶段主要是对业务系统做确认提交，Try阶段执行成功并开始执行 Confirm阶段时，默认 - - - Confirm阶段是不会出错的。即：只要Try成功，Confirm一定成功。
- Cancel 阶段主要是在业务执行错误，需要回滚的状态下执行的业务取消，预留资源释放。

*举个例子，假入 Bob 要向 Smith 转账，思路大概是： 我们有一个本地方法，里面依次调用*
*1：首先在 Try 阶段，要先调用远程接口把 Smith 和 Bob 的钱给冻结起来。*
*2：在 Confirm 阶段，执行远程调用的转账的操作，转账成功进行解冻。*
*3：如果第2步执行成功，那么转账成功，如果第二步执行失败，则调用远程冻结接口对应的解冻方法 (Cancel)。*

优点： 跟2PC比起来，实现以及流程相对简单了一些，但数据的一致性比2PC也要差一些
缺点： 缺点还是比较明显的，在2,3步中都有可能失败。TCC属于应用层的一种补偿方式，所以需要程序员在实现的时候多写很多补偿的代码，在一些场景中，一些业务流程可能用TCC不太好定义及处理。

##### 三、本地消息表（异步确保）比如：支付宝、微信支付主动查询支付状态，对账单的形式

本地消息表与业务数据表处于同一个数据库中，这样就能利用本地事务来保证在对这两个表的操作满足事务特性，并且使用了消息队列来保证最终一致性。

- 在分布式事务操作的一方完成写业务数据的操作之后向本地消息表发送一个消息，本地事务能保证这个消息一定会被写入本地消息表中。
- 之后将本地消息表中的消息转发到 Kafka 等消息队列中，如果转发成功则将消息从本地消息表中删除，否则继续重新转发。
- 在分布式事务操作的另一方从消息队列中读取一个消息，并执行消息中的操作。

![img](https://img-blog.csdnimg.cn/img_convert/d258bb56c17a0be17b1e69dc5406421d.png)

优点： 一种非常经典的实现，避免了分布式事务，实现了最终一致性。
缺点： 消息表会耦合到业务系统中，如果没有封装好的解决方案，会有很多杂活需要处理。

##### 四、MQ 事务消息 异步场景，通用性较强，拓展性较高。

有一些第三方的MQ是支持事务消息的，比如RocketMQ，他们支持事务消息的方式也是类似于采用的二阶段提交，但是市面上一些主流的MQ都是不支持事务消息的，比如 Kafka 不支持。
以阿里的 RabbitMQ 中间件为例，其思路大致为：

- 第一阶段Prepared消息，会拿到消息的地址。 第二阶段执行本地事务，第三阶段通过第一阶段拿到的地址去访问消息，并修改状态。
- 也就是说在业务方法内要想消息队列提交两次请求，一次发送消息和一次确认消息。如果确认消息发送失败了RabbitMQ会定期扫描消息集群中的事务消息，这时候发现了Prepared消息，它会向消息发送者确认，所以生产方需要实现一个check接口，RabbitMQ会根据发送端设置的策略来决定是回滚还是继续发送确认消息。这样就保证了消息发送与本地事务同时成功或同时失败。

![img](https://img-blog.csdnimg.cn/img_convert/deb52e05fedf02aae81f4a0bcedd8a7a.png)

优点： 实现了最终一致性，不需要依赖本地数据库事务。
缺点： 实现难度大，主流MQ不支持，RocketMQ事务消息部分代码也未开源。

##### 五、总结

通过本文我们总结并对比了几种分布式分解方案的优缺点，分布式事务本身是一个技术难题，是没有一种完美的方案应对所有场景的，具体还是要根据业务场景去抉择吧。阿里RocketMQ去实现的分布式事务，现在也有除了很多分布式事务的协调器，比如LCN等，大家可以多去尝试。

### 02、具体实现

分布式事务的完整架构图

![img](https://img-blog.csdnimg.cn/img_convert/f4ebfaace9c354253001a9665836f6a2.png)

**消息冗余表**：在发送消息给rabbitMQ时，同时将消息自己也保存一份，放到消息冗余表中，用来确定消息是否发送给中间件成功。如果消息一直没有投递，那么会在定时器时间到期后，重新投递给消息队列

美团外卖架构：

![img](https://img-blog.csdnimg.cn/img_convert/91b3825eecc604f009825c31bfae4c6f.png)

##### 2-01、系统与系统之间的分布式事务问题

![img](https://img-blog.csdnimg.cn/img_convert/f4eedfd37750d188b158c2c1c9bb32a3.png)

##### 2-02、系统间调用过程中事务回滚问题

```java
package com.xuexiangban.rabbitmq.service;
import com.xuexiangban.rabbitmq.dao.OrderDataBaseService;
import com.xuexiangban.rabbitmq.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
@Service
public class OrderService {
    @Autowired
    private OrderDataBaseService orderDataBaseService;
    // 创建订单
    @Transactional(rollbackFor = Exception.class) // 订单创建整个方法添加事务
    public void createOrder(Order orderInfo) throws Exception {
        // 1: 订单信息--插入丁订单系统，订单数据库事务
        orderDataBaseService.saveOrder(orderInfo);
        // 2：通過Http接口发送订单信息到运单系统
        String result = dispatchHttpApi(orderInfo.getOrderId());
        if(!"success".equals(result)) {
            throw new Exception("订单创建失败,原因是运单接口调用失败!");
        }
    }
    /**
     *  模拟http请求接口发送，运单系统，将订单号传过去 springcloud
     * @return
     */
    private String dispatchHttpApi(String orderId) {
        SimpleClientHttpRequestFactory factory  = new SimpleClientHttpRequestFactory();
        // 链接超时 > 3秒
        factory.setConnectTimeout(3000);
        // 处理超时 > 2秒
        factory.setReadTimeout(2000);
        // 发送http请求
        String url = "http://localhost:9000/dispatch/order?orderId="+orderId;
        RestTemplate restTemplate = new RestTemplate(factory);//异常
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}

```

**回滚问题的根源在这里：**在下单之后，订单服务传递给运单中心，但是可能会存在，订单中心在传递消息给运单中心后，运单中心在运单数据库中做了操作，然后运单中心将成功的消息发送给订单中心时，出现了网络问题等，导致订单中心没有收到，从而发生了异常，订单中心的数据进行了回滚，最后，订单中心回滚，而运单中心进行了派送，最后导致了两者数据不一致。（由于没有代码，所以我也就没有写，只是将场景进行了分析）

##### 2-03、基于MQ的分布式事务整体设计思路

![img](https://img-blog.csdnimg.cn/img_convert/aba868fd7bf20f721f873a700b221e48.png)

##### 2-04、基于MQ的分布式事务消息的可靠生产问题

![img](https://img-blog.csdnimg.cn/img_convert/852ffa825bd41417639774af15d62456.png)

**核心就是rabbitMQ的消息确认机制，在生产者生产消息之后，将消息投递给队列后，判断队列发送过来的ACK回执，从而判断消息是否有没有可靠投递，**

```java

//该注解用来修饰一个非静态的void()方法，被该注解修饰的方法会在服务器加载Servlet的时候运行
//并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行
@PostConstruct
public void regCallback(){
    //消息发送成功后，给予生产者的消息回执，来确保生产者的可靠性
    rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback(){
        @Override
        public void confirm(Correlation correlationData,boolean ack,String cause){
            System.out.println("cause:" + cause);
            //如果ack为true，则表示消息已经被i收到
            String orderId = correlationData.getId();
            if(!ack){
                System.out.println("MQ队列响应失败，orderID是:" + orderId);
                return;
            }
            try{
                String sql = "update ksd_order_message set status = 1 where order_id = ?";
                int count = jdbcTemplate.update(sql,orderId);
                if(count == 1){
                     System.out.println("投递成功");
                }
            }
            catch(Exception e){
                System.out.println("投递失败");
            }
        }
    });
}
```

如果这个时候MQ服务器出现了异常和故障，那么消息是无法获取到回执信息。怎么解决呢？

##### 2-05、基于MQ的分布式事务消息的可靠生产问题-定时重发

![img](https://img-blog.csdnimg.cn/img_convert/354bafd9decdc09b64491140c598d3b5.png)

```java
@EnableScheduling
public class TaskService{
    @Scheduled(cron = "xxxxxx")
    public void sendMessage(){
        //把状态为0的消息重新查询出来，投递到MQ中
    }
}
```

##### 2-06、基于MQ的分布式事务消息的可靠消费

如果消费者在消费过程中出现了故障，会触发rabbitMQ的重新消费的机制，会出现无限循环的问题。

解决方案：

1.控制消费者的重发次数，用重试次数就不要用try catch

2.使用try catch + 手动ack

3.使用try catch + 手动ack + 死信队列处理

![img](https://img-blog.csdnimg.cn/img_convert/3dc25dcadc591a661fe44956066e6c54.png)

##### 2-07、基于MQ的分布式事务消息的消息重发

![img](https://img-blog.csdnimg.cn/img_convert/cee42f3ebfd3a931e952378de305d07e.png)

##### 2-08、基于MQ的分布式事务消息的死信队列消息转移 + 人工处理

![img](https://img-blog.csdnimg.cn/img_convert/016cdadbf27e7bebdda605fc9e7921d9.png)

如果死信队列报错就进行人工处理

![img](https://img-blog.csdnimg.cn/img_convert/13654d334327be3a1285b798a39bd306.png)