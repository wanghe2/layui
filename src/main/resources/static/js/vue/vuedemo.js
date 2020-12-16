var instance = axios.create({
    baseURL: '/',
    timeout: 6000,
    headers: {
        'Content-Type': 'multipart/form-data',
        Accept: '*/*'
    },
});
new Vue({
    el:'#demo',
    data() {
        return {
            name: 'wanghe',
            iconUrl: '',
            miniAppUrl: ''
        }
    },
    mounted(){
        this.iconUrl = 'https://yn-seal-test-1300564492.cos.ap-beijing.myqcloud.com/datastation/file/data/1606113423568.png';
        this.miniAppUrl = 'https://yn-seal-test-1300564492.cos.ap-beijing.myqcloud.com/datastation/file/data/1605750110278.png';
        this.generatePoster();
    },
    methods: {
        say() {
            alert('good');
        },
        timeOut() {
        	instance.get('timeOutTest').then(function (response) {
        		alert(response);
            }).catch(function (error) {
                alert(error);
            });
        },
        async generatePoster(){
            await new Promise((resolve, reject) => {
                let image = new Image();
                image.crossOrigin = "";

                image.onload = function() {
                    console.log("成功加载封面图",image.src);
                    resolve();
                };
                image.src = this.miniAppUrl;
                image.onerror = function() {
                    // self.generatingPoster = false;
                    // self.$message.error("加载封面图失败");
                    console.log("加载封面图失败");
                };
                // setTimeout(()=>{
                //     resolve();
                // },5000)
            });
            // 二维码加载
            await new Promise((resolve, reject) => {
                // setTimeout(() => {
                //   resolve();
                // }, 3000);
                let image = new Image();
                image.crossOrigin = "";

                image.onload = function() {
                    console.log('成功加载小程序码',image.src);
                    resolve();
                };
                image.src = this.miniAppUrl;
                image.onerror = function() {
                    // self.generatingPoster = false;
                    // self.$message.error("加载小程序二维码图片失败");
                    console.log("加载小程序二维码图片失败");
                };
            });
            //生成海报
            // const canvas = await html2canvas(this.$refs.poster, {
            //     dpi: window.devicePixelRatio * 4,
            //     useCORS: true,
            //     scale: 1, // 添加的scale 参数
            //     allowTaint: true,
            //     backgroundColor: null,
            //     // width: 290,
            //     // height: 366,
            //     scrollY: 0,
            //     scrollX: 0,
            //     ignoreElements: element => {
            //         if (element.tagName == "ION-ICON") return true;
            //     }
            // });
            // var oImg=new Image();
            // oImg.src = canvas.toDataURL();  // 导出图片
            // document.body.appendChild(oImg);  // 将生成的图片添加到body

        }
    }
})



function say(){
	console.log('good')
}