(function (a) {
    a.fn.upload = function (D) {
        var r = a(this), w = "<li class='item'></li>",
            A = a('<li class="item add"><svg class="icon" viewBox="0 0 1024 1024" version="1" xmlns="http://www.w3.org/2000/svg" width="200" height="200"><defs><style/></defs><path d="M737 436a174 174 0 0 1 172 172 172 172 0 0 1-172 172c-69 1-69 107 0 106 152-2 276-125 278-278S886 332 737 330c-69-1-69 105 0 106zM285 779a174 174 0 0 1-172-172 172 172 0 0 1 172-172c68-1 69-106 0-106A282 282 0 0 0 7 607a281 281 0 0 0 278 278c69 1 68-105 0-106z" fill="#4A5699"/><path d="M340 384a174 174 0 0 1 172-172 172 172 0 0 1 172 172c1 68 106 68 106 0a282 282 0 0 0-278-278 281 281 0 0 0-278 278c-1 68 105 68 106 0z" fill="#C45FA0"/><path d="M545 473c17 17 17 43 0 60L422 656a42 42 0 0 1-60-60l123-123c17-16 43-16 60 0z" fill="#F39A2B"/><path d="M485 473c17-16 44-16 60 0l123 123a42 42 0 0 1-60 60L485 533a42 42 0 0 1 0-60z" fill="#F39A2B"/><path d="M514 634c24 0 43 20 43 43v179a43 43 0 0 1-86 0V677c0-23 19-43 43-43z" fill="#E5594F"/></svg></li>'),
            e = '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="300" height="300" class="progress"><g fill="rgba(17,89,164,0.1)"><path d="M 0 70 Q 75 39, 150 70 T 300 70 T 450 70 T 600 70 T 750 70 V 320 H 0 V 0"></path><animateTransform attributeName="transform" attributeType="XML" type="translate" from="0" to="-300" dur="1.5s" repeatCount="indefinite"></animateTransform></g><g fill="rgba(17,89,164,0.15)"><path d="M 0 70 Q 87.5 47, 175 70 T 350 70 T 525 70 T 700 70 T 875 70 T 1050 70 V 320 H 0 V 0"></path><animateTransform attributeName="transform" attributeType="XML" type="translate" from="0" to="-350" dur="3s" repeatCount="indefinite"></animateTransform></g></svg><div class="progressnum"></div>',
            g = '<svg xmlns="http://www.w3.org/2000/svg" class="delete" version="1" viewBox="0 0 1024 1024"><path fill="#fff" d="M512 70a439 439 0 0 1 442 442 439 439 0 0 1-442 442A439 439 0 0 1 70 512 439 439 0 0 1 512 70m0-40a482 482 0 1 0 0 964 482 482 0 0 0 0-964zm114 253v-1c0-21-17-38-38-38H436c-21 0-38 17-38 38v1H282v74h460v-74H626zM321 396v346c0 21 17 38 38 38h306c21 0 38-17 38-38V396H321zm114 306h-76V474h76v228zm115 0h-76V474h76v228zm115 0h-76V474h76v228z"/></svg>',
            E = '<svg xmlns="http://www.w3.org/2000/svg" class="look" version="1" viewBox="0 0 1024 1024"><path fill="#fff" d="M451 835a386 386 0 1 1 0-771 386 386 0 0 1 0 771zm0-675a291 291 0 1 0 0 581 291 291 0 0 0 0-581zm450 798c-15 0-30-5-42-17L658 740a58 58 0 0 1 83-82l201 201a58 58 0 0 1-41 99"/></svg>',
            d = a('<input type="file" name="file" />'), b = a('<input type="hidden" />'), j, u, t, o, n, m, y, B = {
                height: r.attr("data-height") ? r.attr("data-height") : 0,
                width: r.attr("data-width") ? r.attr("data-width") : 1920,
                type: r.attr("data-type") ? r.attr("data-type") : "png,jpg,jpeg,gif",
                upname: r.attr("data-file") ? r.attr("data-file") : "file",
                inputname: r.attr("data-name") ? r.attr("data-name") : "upload",
                num: r.attr("data-num") ? r.attr("data-num") : 10,
                action: r.attr("action") ? r.attr("action") : "/index.php",
                size: r.attr("data-size") ? r.attr("data-size") : 20480,
                value: r.attr("data-value") ? r.attr("data-value") : "",
                file: r.attr("data-files") ? r.attr("data-files") : "",
                show: r.attr("data-show") ? r.attr("data-show") : ""
            };

        r.append(A.attr("data-num", B.num).attr("data-type", B.type)).append(d.attr("multiple", B.num > 1 ? "multiple" : false)).append(b.attr("name", B.inputname)).addClass(B.num > 1 ? "multiple" : "one").on("click", "li.add", function () {
            d.click()
        }).on("change", "input[type='file']", function (H) {
            var G = H.target.files;
            var i = [];
            for (var F in G) {
                if (typeof G[F] == "object") {
                    i.push(G[F])
                }
            }
            C(i)
        }).on("click", "li.error", function (i) {
            z(a(i.currentTarget))
        }).on("click", "svg.delete", function (i) {
            z(a(i.currentTarget).parent("li.success"))
        }).on("click", "svg.look", function (i) {
            debugger;
            if (D && typeof D == "function") {
                D(r, a(i.currentTarget).parent("li.success").data("z_url"), a(i.currentTarget).parent("li.success").data("filename"))
            }
        }).on("mousedown", "li.success", function (I) {
            var i = a(I.target);
            j = a(this);
            var J = j.offset();
            var H = r.offset();
            var G = J.left;
            var F = J.top;
            u = parseInt(G) + (I.pageX - parseInt(G)) + (H.left - J.left);
            t = parseInt(F) + (I.pageY - parseInt(F)) + (H.top - J.top);
            m = j.width() + 2 + j.css("margin-right").replace("px", "") * 1;
            y = j.height() + 2 + j.css("margin-bottom").replace("px", "") * 1;
            o = false;
            n = false
        });

        if (B.file) {
            var f=JSON.parse(B.file), s = 0, h = "";
            var i=0;
            for (var x in f) {
                if (s < B.num && f[s]) {
                    var name=f[s].name;
                    var J=name.split('.')[name.split('.').length - 1];
                    var url=f[s].id;
                    if(B.show){
                        url=f[s].url;
                        if (["png", "jpg", "jpeg", "gif", "bmp"].indexOf(J) >= 0) {
                            h = a("<li class='item success'></li>").append(typeof D == "function" ? E : "").data("url", url).attr("data-z_url", f[s].url).attr("data-filename", name).css("background-image", "url('" + f[s].url + "')").insertBefore(A);
                        }else {
                            var N = k(J);
                            h = a("<li class='item success'></li>").append(N).append("<div class='filename'>" + name + "</div>").append(typeof D == "function" ? E : "").data("url", url).attr("data-z_url", f[s].url).attr("data-filename", name).insertBefore(A);
                        }
                    }else {
                        if (["png", "jpg", "jpeg", "gif", "bmp"].indexOf(J) >= 0) {
                            h = a("<li class='item success'></li>").append(g).append(typeof D == "function" ? E : "").data("url", url).attr("data-z_url", f[s].url).attr("data-filename", name).css("background-image", "url('" + f[s].url + "')").insertBefore(A);
                        }else {
                            var N = k(J);
                            h = a("<li class='item success'></li>").append(N).append("<div class='filename'>" + name + "</div>").append(g).append(typeof D == "function" ? E : "").data("url", url).attr("data-z_url", f[s].url).attr("data-filename", name).insertBefore(A);
                        }
                    }
                    r.data("num", ++i).removeClass("empty");
                    q()
                }
                s++
            }
        }else if (B.value) {
            var p = B.value.split(","), s = 0, h = "";
            var f = 0;
            for (var x in p) {
                if (s < B.num && p[s]) {
                    h = a("<li class='item success'></li>").append(g).append(typeof D == "function" ? E : "").data("url", p[s]).attr("data-filename", c(p[s])).css("background-image", "url('" + p[s] + "')").insertBefore(A);
                    r.data("num", ++f).removeClass("empty");
                    q()
                }
                s++
            }
        }
        else {
            r.data("num", 0).addClass("empty")
        }
        a(document).on("mousemove", function (G) {
            if (j) {
                var F = G.pageX - u;
                var J = G.pageY - t;
                var I = j.index();
                var H = r.offset();
                var i = r.height() ? r.height() : 134;
                j.css({top: J, left: F, zIndex: 999, position: "absolute"});
                o = G.pageX - H.left;
                n = G.pageY - H.top;
                if (n > (i + 20) || n < 0) {
                    j.addClass("delete")
                } else {
                    j.removeClass("delete")
                }
                o = parseInt(o / m);
                n = parseInt(n / y);
                o = parseInt(o + (r.width() / m) * n);
                if (o >= I) {
                    o++
                }
                r.children("li").not(j).css("margin-left", 0);
                r.children("li").eq(o).not(j).css("margin-left", m)
            }
        }).on("mouseup", function () {
            if (j) {
                if (j.hasClass("delete") && j.data("filename")) {
                    z(j);
                    j = false;
                    r.children("li").not(".add").css({
                        "position": "relative",
                        "top": 0,
                        "left": 0,
                        "margin-left": 0,
                        "zIndex": 0
                    });
                    r.children("li.add").css("margin-left", 0);
                    return false
                }
                var i = j.clone();
                i.data("url", j.data("url"));
                if (o !== false) {
                    if (o >= r.children("li").size()) {
                        i.insertBefore(A)
                    } else {
                        i.insertBefore(r.children("li").eq(o))
                    }
                    j.remove();
                    q();
                    r.children("li").not(".add").css({
                        "position": "relative",
                        "top": 0,
                        "left": 0,
                        "margin-left": 0,
                        "zIndex": 0
                    });
                    r.children("li.add").css("margin-left", 0)
                }
            }
            j = false
        }).on("dragenter", function (i) {
            i.preventDefault()
        }).on("dragover", function (i) {
            i.preventDefault();
            if (a(i.target).hasClass("upload")) {
                r.addClass("dragenter")
            } else {
                r.removeClass("dragenter")
            }
        }).on("drop", function (H) {
            H.preventDefault();
            r.removeClass("dragenter");
            var G = H.originalEvent.dataTransfer.files;
            var i = [];
            for (var F in G) {
                if (typeof G[F] == "object") {
                    i.push(G[F])
                }
            }
            C(i);
            return false
        });

        function C(H) {
            var G = H;
            for (var F in G) {
                if (typeof G[F] == "object") {
                    var i = l(G[F], function (K, J, I) {
                        J.insertBefore(A);
                        var L = new FormData();
                        L.append(B.upname, K, I.name);
                        r.removeClass("empty");
                        a.ajax({
                            url: B.action,
                            type: "POST",
                            data: L,
                            dataType: "text",
                            processData: false,
                            contentType: false,
                            success: function (M) {
                                M = JSON.parse(M);
                                J.children("svg.progress").remove();
                                J.children(".progressnum").remove();
                                if (M.code) {
                                    J.addClass("success").append(g).append(typeof D == "function" ? E : "").data("url", M.id).data("z_url", M.url)
                                } else {
                                    J.addClass("error").attr("data-error", M.id ? M.id : "服务端返回数据异常")
                                }
                                q()
                            },
                            xhr: function () {
                                var M = new XMLHttpRequest();
                                M.upload.addEventListener("progress", function (N) {
                                    if (N.lengthComputable) {
                                        var O = Math.round(N.loaded * 100 / N.total);
                                        J.children("svg.progress").css("height", 50 + (120 * O / 100) + "%");
                                        J.children(".progressnum").text(O)
                                    }
                                }, false);
                                return M
                            },
                            error: function () {
                                J.addClass("error").attr("data-error", "网络连接异常！");
                                q()
                            }
                        })
                    })
                }
            }
        }

        function l(G, L) {
            d.val("");
            if (B.num == 1) {
                r.children(".item").not(".add").remove()
            } else {
                if (B.num <= r.data("num")) {
                    return false
                }
                r.data("num", r.data("num") + 1)
            }
            var F = G.size, J = G.name.toLowerCase().split(".").splice(-1).join(), i = a(w);
            var I = B.type.split(",");
            if (I.indexOf(J) < 0) {
                var K = "不能上传." + J + "的文件!"
            }
            if (["png", "jpg", "jpeg", "gif", "bmp"].indexOf(J) < 0 && F > B.size * 1024) {
                var K = "不能上传大于." + B.size + "KB 的文件!"
            }
            if (K) {
                i.append(k(J)).addClass("error").append("<div class='filename'>" + G.name + "</div>").attr("data-error", K).insertBefore(A);
                r.removeClass("empty");
                q();
                return false
            }
            var H = new FileReader();
            H.readAsDataURL(G);
            H.onload = function () {
                var P = c(G.name) + c(G.type) + c(G.size.toString()) + c(H.result);
                if (r.children('li[data-filename="' + P + '"]').size() > 0) {
                    return false
                }
                i.attr("data-filename", P);
                if (["png", "jpg", "jpeg", "gif", "bmp"].indexOf(J) >= 0) {
                    var O = new Image();
                    O.src = H.result;
                    O.onload = function () {
                        var V = this;
                        var X = V.width, T = V.height, S = X / T;
                        if (B.width && B.width < X) {
                            X = B.width;
                            T = X / S
                        } else {
                            if (B.height && T > B.height) {
                                T = B.height;
                                X = T * S
                            }
                        }
                        var Y = 1;
                        var Q = document.createElement("canvas");
                        var aa = Q.getContext("2d");
                        var W = document.createAttribute("width");
                        W.nodeValue = X;
                        var R = document.createAttribute("height");
                        R.nodeValue = T;
                        Q.setAttributeNode(W);
                        Q.setAttributeNode(R);
                        aa.drawImage(V, 0, 0, X, T);
                        var U = Q.toDataURL("image/jpeg", Y);
                        i.css("background-image", "url('" + U + "')").append(e);
                        var Z = v(U);
                        L(Z, i, G);
                        return
                    }
                } else {
                    var N = k(J);
                    i.append(N).append("<div class='filename'>" + G.name + "</div>").append(e);
                    var M = G;
                    L(M, i, G);
                    return
                }
            }
        }

        function v(G) {
            var i = G.split(","), I = i[0].match(/:(.*?);/)[1], F = atob(i[1]), J = F.length, H = new Uint8Array(J);
            while (J--) {
                H[J] = F.charCodeAt(J)
            }
            return new Blob([H], {type: I})
        }

        function c(F) {
            var J = 5381, I = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".split(""),
                G = F.length - 1;
            if (typeof F == "string") {
                for (; G > -1; G--) {
                    J += (J << 5) + F.charCodeAt(G)
                }
            } else {
                for (; G > -1; G--) {
                    J += (J << 5) + F[G]
                }
            }
            var H = J & 2147483647;
            var K = "";
            do {
                K += I[H & 63]
            } while (H >>= 6);
            return K
        }

        function k(i) {
            if (["asp", "php", "js", "java", "html", "css", "sql"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><defs/><path fill="#FF8976" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#FFD0C8" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M422 564l-118 46 118 47v37l-163-65v-37l163-65v37zm116-106h37l-89 240h-37l89-240zm64 200l118-47-118-46v-37l163 64v38l-163 64v-36z"/></svg>'
            }
            if (["psb", "psd"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#8095FF" d="M168 32c-12 0-25 5-34 14s-14 22-14 34v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L648 32H168z"/><path fill="#CCD5FF" d="M920 304H696c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#C0CAFF" d="M504 550c5-2 10-4 16-4s11 2 16 4l185 108c5 2 8 8 8 13s-3 11-8 14L534 793c-4 2-10 4-16 4s-11-2-16-4L318 686c-5-3-8-8-8-14s3-11 8-14l186-108z"/><path fill="#FFF" d="M504 390c5-2 10-4 16-4s11 2 16 4l185 108c5 2 8 8 8 13s-3 11-8 14L534 633c-4 2-10 4-16 4s-11-2-16-4L318 526c-5-3-8-8-8-14s3-11 8-14l186-108z"/></svg>'
            }
            if (["xls", "xlsx", "number", "et", "ett"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#5ACC9B" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#BDEBD7" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M475 538L366 386h76l71 108 74-108h73L549 538l117 161h-76l-79-115-78 116h-75l117-162z"/></svg>'
            }
            if (["wps", "wpt", "page", "doc", "docx"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#6CCBFF" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#C4EAFF" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M280 386h65l65 244 72-244h62l72 244 66-244h62l-96 314h-65l-71-242h-1l-72 241h-65l-94-313z"/></svg>'
            }
            if (["ppt", "pptx", "key", "dps", "dpt", "wpp"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#FF8976" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#FFD0C8" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M386 386h176c70 0 92 47 92 97 0 48-28 97-92 97H446v120h-60V386zm60 145h96c35 0 53-10 53-47 0-38-25-48-48-48H446v95z"/></svg>'
            }
            if (i == "pdf") {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#FF5562" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#FFBBC0" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M696 843c-50 0-95-86-119-142-40-17-84-32-127-43-37 25-100 62-149 62-31 0-52-15-60-42-7-21-1-36 5-44 13-18 40-27 80-27 32 0 72 6 118 17 30-21 59-45 86-70-12-56-25-147 8-188 16-20 40-27 70-18 33 10 45 30 49 45 13 54-49 128-91 171 9 38 21 77 36 113 61 27 133 67 141 111 3 15-1 30-13 42-11 8-22 13-34 13zm-74-121c30 61 59 90 74 90 2 0 6-1 10-5 6-5 6-9 5-13-3-16-29-42-89-72zm-296-83c-40 0-51 10-54 14-1 1-4 5-1 17 3 9 9 19 30 19 25 0 62-15 105-40-31-7-58-10-80-10zm158-5c26 8 52 16 77 26-9-23-16-47-23-70l-54 44zm99-258c-9 0-15 3-21 10-16 20-18 73-5 140 49-52 75-100 69-125-1-4-4-15-27-22l-16-3z"/></svg>'
            }
            if (i == "txt") {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#E5E5E5" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#CCC" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M264 376h208c14 0 24-10 24-24s-10-24-24-24H264c-14 0-24 10-24 24s10 24 24 24zm0 160h496c14 0 24-10 24-24s-10-24-24-24H264c-14 0-24 10-24 24s10 24 24 24zm496 112H264c-14 0-24 10-24 24s10 24 24 24h496c14 0 24-10 24-24s-10-24-24-24z"/></svg>'
            }
            if (["zip", "rar", "gzip", "7-zip", "zipz", "rarr", "iso"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#5ACC9B" d="M944 944H80c-26 0-48-18-48-41V656h960v247c0 23-22 41-48 41z"/><path fill="#6CCBFF" d="M80 80h864c26 0 48 18 48 41v247H32V121c0-23 22-41 48-41z"/><path fill="#FFD766" d="M32 368h960v288H32z"/><path fill="#FF5562" d="M352 80h320v864H352z"/><path fill="#FFF" d="M444 128h64v48h-64zm64-48h64v48h-64zm0 96h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm64 48h64v48h-64zm-64 48h64v48h-64zm0 96h64v48h-64zm64-48h64v48h-64z"/></svg>'
            }
            if (["avi", "wmv", "mpeg", "mp4", "mov", "mkv", "flv", "f4v", "m4v", "rmvb", "rm", "3gp", "dat", "ts", "mts", "vob"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#8095FF" d="M80 34h864v960H80z"/><path fill="#FFF" d="M136 112a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM136 272a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM136 432a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM136 592a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM136 752a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM136 912a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 112a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 272a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 432a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 592a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 752a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM824 912a40 40 0 1 0 80 0 40 40 0 1 0-80 0zM648 508L436 362c-5-3-11-4-17 0-5 3-9 8-9 14v290c0 6 4 12 9 15 6 3 12 2 17-1l212-146c5-3 7-8 7-13s-3-10-7-13z"/></svg>'
            }
            if (["gif", "jpg", "jpeg", "png", "bmp"].indexOf(i) >= 0) {
                return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><defs/><path fill="#FF5562" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#FFBBC0" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/><path fill="#FFF" d="M758 706L658 550c-3-4-8-7-13-7s-11 3-14 7l-53 84-120-195c-4-5-8-7-14-7s-10 3-14 7L266 706c-4 4-4 11 0 16 3 5 8 8 13 8h466c5 0 11-4 14-8 3-6 3-12-1-16zM622 412a40 40 0 1 0 80 0 40 40 0 1 0-80 0z"/></svg>'
            }
            return '<svg xmlns="http://www.w3.org/2000/svg" class="icon" version="1" viewBox="0 0 1024 1024"><path fill="#E5E5E5" d="M160 32a49 49 0 0 0-48 48v864c0 12 5 25 14 34 10 9 22 14 34 14h704c12 0 25-5 34-14 9-10 14-22 14-34V304L640 32H160z"/><path fill="#CCC" d="M912 304H688c-12 0-25-5-34-14s-14-22-14-34V32l272 272z"/></svg>'
        }

        function q() {
            var i = [];
            r.children("li.success").each(function () {
                i.push(a(this).data("url"))
            });
            if (r.children("li").not(".add").size() >= B.num && B.num > 1) {
                A.hide()
            } else {
                A.show()
            }
            if (r.children("li").not(".add").size() == 0) {
                r.addClass("empty")
            }
            b.val(i.join(","))
        }

        function z(i) {
            i.fadeOut(333, function () {
                i.remove();
                q()
            });
            r.data("num", r.data("num") - 1)
        }
    }
})(jQuery);

function download(url,name) {
    if (isIE()) { // IE
        window.open(url, '_blank')
    } else {
        let a = document.createElement('a') // 创建a标签
        let e = document.createEvent('MouseEvents') // 创建鼠标事件对象
        e.initEvent('click', false, false) // 初始化事件对象
        a.href = url // 设置下载地址
        a.download = name // 设置下载文件名
        a.dispatchEvent(e)
    }
}

function isIE() {
    var navigator = window.navigator.userAgent;
    if (navigator.indexOf("MSIE") > 0 ||
        navigator.indexOf("Trident") > 0 ||
        navigator.indexOf("Edge") > 0) {
        return true;
    }
    return false
}

function showPhoto(url) {
    debugger;
    layer.photos({photos: {"data": [{"src": url}]}});
}

$(document).on("mousewheel DOMMouseScroll", ".layui-layer-phimg img", function (e) {
    var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) || // chrome & ie
        (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1)); // firefox
    var imagep = $(".layui-layer-phimg").parent().parent();
    var image = $(".layui-layer-phimg").parent();
    var h = image.height();
    var w = image.width();
    if (delta > 0) {
        h = h * 1.05;
        w = w * 1.05;
    } else if (delta < 0) {
        if (h > 100) {
            h = h * 0.95;
            w = w * 0.95;
        }
    }
    /*imagep.css("top", (window.innerHeight - h) / 2);
    imagep.css("left", (window.innerWidth - w) / 2);*/
    image.height(h);
    image.width(w);
    imagep.height(h);
    imagep.width(w);
});