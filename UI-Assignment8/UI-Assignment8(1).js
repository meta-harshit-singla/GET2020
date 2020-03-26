node = function (data) {
    this.data = data;
    this.next = null;
}
singlyLinkedList = function () {
    this.head = null;
    this.size = 0;
    //this method is used to add a node at the end of the list
    this.addNode = function (data) {
        //create new node
        var newNode = new node(data);

        //to store current node
        var currentNode;
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            currentNode = this.head;
            //iterate until we reach the end node
            while (currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        this.size++;
    }
    //this method is used to delete the specific node which contains the required data
    this.deleteNode = function (data) {
        var currentNode = this.head;
        var previousNode = null;
        //iterate till the end of the list
        while (currentNode != null) {
            if (currentNode.data == data) {
                if (previousNode == null) {
                    this.head = currentNode.next;
                }
                else {
                    previousNode.next = currentNode.next;
                }
                this.size--;
                return "Deleted";
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return "Not found";
    }
    //this method is used to tell the size of the list
    this.sizeList = function () {
        console.log(this.size);
    }
    //this method is used to show the elements in the list
    this.showElements = function () {
        var currentNode = this.head;
        while (currentNode != null) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}