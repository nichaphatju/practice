function solution(T) {
    // Implement your solution here
    if(!T) return -1;
    return calculateTreeHeight(T);
}
function calculateTreeHeight(root){
        if (!root) {
            // console.log('-- No Root Data --')
            return 0;
        }
        // console.log('-- Root '+root.x+' >>> '+ root.l + ' - ' +root.r)
        if (root.l != null || root.r != null) {
            return 1 + 
                max(calculateTreeHeight(root.l), 
                    calculateTreeHeight(root.r));
        }
        return 0;
}
function max(a, b){
    // console.log('LEFT H : '+a + ' RIGHT H : '+b);
    if(a >= b) return a;
    return b;
}