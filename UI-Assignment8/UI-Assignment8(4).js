stack = function () {
    this.stackArray = [];
    this.addItem = function (item) {
        this.stackArray.push(item);
    }
    this.popItem = function () {
        return this.stackArray.pop();
    }
    this.peepStack = function () {
        return this.stackArray[this.stackArray.length - 1];
    }
}