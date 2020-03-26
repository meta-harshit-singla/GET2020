//structure of link list
Node = function (data) {
    this.data = data;
    this.next = null;
    this.prev = null;
}

//implementation of linklist
linklist = function () {
    this.head = null;
    this.size = 0;
    this.tail = null;

    //add the element to link list
    this.add = function (data) {
        var node = new Node(data);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    //delete the node
    this.delete = function (item) {
        let current = this.head;
        while (current) {
            if (current.data === item) {
                if (current == this.head && current == this.tail) {
                    this.head = null;
                    this.tail = null;

                } else if (current == this.head) {
                    this.head = this.head.next
                    this.head.prev = null
                    this.size--;
                } else if (current == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                    this.size--;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }


    }
    //show the list
    this.showList = function () {
        var current = this.head;
        while (current != null) {
            console.log(current.data);
            current = current.next;
        }
    }
}