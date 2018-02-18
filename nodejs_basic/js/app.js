new Vue({
    el : '#vue-app',
    data : {
        name : 'betterFLY',
        job : 'programmer',
        website : 'http://stackunderflow.tistory.com/',
        websiteTag : '<a href="http://stackunderflow.tistory.com/">Stack underflow website'
    },
    methods : {
        greet : function(item){
            
            return item +" // "+ this.name + " // " + this.job
        }
    }
});