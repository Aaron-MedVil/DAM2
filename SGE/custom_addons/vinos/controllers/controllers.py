# -*- coding: utf-8 -*-
# from odoo import http


# class Vinos(http.Controller):
#     @http.route('/vinos/vinos/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/vinos/vinos/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('vinos.listing', {
#             'root': '/vinos/vinos',
#             'objects': http.request.env['vinos.vinos'].search([]),
#         })

#     @http.route('/vinos/vinos/objects/<model("vinos.vinos"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('vinos.object', {
#             'object': obj
#         })
