queue = function () {
    this.items = [];
    this.enqueue = function (element) {
        this.items.push(element);
    }
    this.dequeue = function () {
        return this.items.shift();
    }
}