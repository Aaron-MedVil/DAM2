# -*- coding: utf-8 -*-
# from odoo import http


# class Brands(http.Controller):
#     @http.route('/brands/brands/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/brands/brands/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('brands.listing', {
#             'root': '/brands/brands',
#             'objects': http.request.env['brands.brands'].search([]),
#         })

#     @http.route('/brands/brands/objects/<model("brands.brands"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('brands.object', {
#             'object': obj
#         })
